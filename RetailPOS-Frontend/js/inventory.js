/*
===================================
INVENTORY MODULE
===================================
Developer: Frontend Team
Purpose: Handle inventory management and stock monitoring
Simulates: InventoryService.java from backend
===================================
*/

let currentFilter = 'all';
let selectedProductForStock = null;

/**
 * Load on page ready
 */
document.addEventListener('DOMContentLoaded', function() {
    checkAuth();
    loadInventory();
    updateInventorySummary();
});

/**
 * Load inventory table
 */
function loadInventory() {
    const products = JSON.parse(localStorage.getItem('products')) || [];
    let filtered = filterProducts(products, currentFilter);
    
    const tableBody = document.getElementById('inventoryTable');
    
    if (filtered.length === 0) {
        tableBody.innerHTML = '<tr><td colspan="8" class="empty-message">No products found</td></tr>';
        return;
    }
    
    tableBody.innerHTML = filtered.map(product => {
        const stockValue = product.price * product.stockQuantity;
        const status = getStockStatus(product.stockQuantity);
        
        return `
            <tr>
                <td>${product.productId}</td>
                <td>${product.productName}</td>
                <td>${product.category}</td>
                <td>₹${parseFloat(product.price).toFixed(2)}</td>
                <td>${product.stockQuantity}</td>
                <td>₹${stockValue.toFixed(2)}</td>
                <td>
                    <span class="stock-status stock-${status.class}">
                        ${status.text}
                    </span>
                </td>
                <td>
                    <button onclick="showUpdateStockModal('${product.productId}')" 
                            class="btn btn-sm btn-primary btn-icon" 
                            title="Update Stock">
                        <svg width="16" height="16" viewBox="0 0 24 24" fill="currentColor">
                            <path d="M3 17.25V21h3.75L17.81 9.94l-3.75-3.75L3 17.25zM20.71 7.04c.39-.39.39-1.02 0-1.41l-2.34-2.34c-.39-.39-1.02-.39-1.41 0l-1.83 1.83 3.75 3.75 1.83-1.83z"/>
                        </svg>
                    </button>
                </td>
            </tr>
        `;
    }).join('');
}

/**
 * Filter products based on stock status
 */
function filterProducts(products, filter) {
    switch (filter) {
        case 'instock':
            return products.filter(p => p.stockQuantity >= 10);
        case 'lowstock':
            return products.filter(p => p.stockQuantity > 0 && p.stockQuantity < 10);
        case 'outofstock':
            return products.filter(p => p.stockQuantity === 0);
        default:
            return products;
    }
}

/**
 * Get stock status
 */
function getStockStatus(quantity) {
    if (quantity === 0) {
        return { class: 'out', text: 'Out of Stock' };
    } else if (quantity < 10) {
        return { class: 'low', text: 'Low Stock' };
    } else {
        return { class: 'in', text: 'In Stock' };
    }
}

/**
 * Filter inventory
 */
function filterInventory() {
    currentFilter = document.getElementById('filterStock').value;
    loadInventory();
}

/**
 * Search inventory
 */
function searchInventory() {
    const searchTerm = document.getElementById('searchInventory').value.toLowerCase();
    const products = JSON.parse(localStorage.getItem('products')) || [];
    
    let filtered = products.filter(p => 
        p.productId.toLowerCase().includes(searchTerm) ||
        p.productName.toLowerCase().includes(searchTerm) ||
        p.category.toLowerCase().includes(searchTerm)
    );
    
    filtered = filterProducts(filtered, currentFilter);
    
    const tableBody = document.getElementById('inventoryTable');
    
    if (filtered.length === 0) {
        tableBody.innerHTML = '<tr><td colspan="8" class="empty-message">No products found</td></tr>';
        return;
    }
    
    tableBody.innerHTML = filtered.map(product => {
        const stockValue = product.price * product.stockQuantity;
        const status = getStockStatus(product.stockQuantity);
        
        return `
            <tr>
                <td>${product.productId}</td>
                <td>${product.productName}</td>
                <td>${product.category}</td>
                <td>₹${parseFloat(product.price).toFixed(2)}</td>
                <td>${product.stockQuantity}</td>
                <td>₹${stockValue.toFixed(2)}</td>
                <td>
                    <span class="stock-status stock-${status.class}">
                        ${status.text}
                    </span>
                </td>
                <td>
                    <button onclick="showUpdateStockModal('${product.productId}')" 
                            class="btn btn-sm btn-primary btn-icon" 
                            title="Update Stock">
                        <svg width="16" height="16" viewBox="0 0 24 24" fill="currentColor">
                            <path d="M3 17.25V21h3.75L17.81 9.94l-3.75-3.75L3 17.25zM20.71 7.04c.39-.39.39-1.02 0-1.41l-2.34-2.34c-.39-.39-1.02-.39-1.41 0l-1.83 1.83 3.75 3.75 1.83-1.83z"/>
                        </svg>
                    </button>
                </td>
            </tr>
        `;
    }).join('');
}

/**
 * Update inventory summary cards
 */
function updateInventorySummary() {
    const products = JSON.parse(localStorage.getItem('products')) || [];
    
    const inStock = products.filter(p => p.stockQuantity >= 10).length;
    const lowStock = products.filter(p => p.stockQuantity > 0 && p.stockQuantity < 10).length;
    const outOfStock = products.filter(p => p.stockQuantity === 0).length;
    
    const totalValue = products.reduce((sum, p) => sum + (p.price * p.stockQuantity), 0);
    
    document.getElementById('inStockCount').textContent = inStock;
    document.getElementById('lowStockCount').textContent = lowStock;
    document.getElementById('outOfStockCount').textContent = outOfStock;
    document.getElementById('totalValue').textContent = '₹' + totalValue.toFixed(2);
}

/**
 * Show update stock modal
 */
function showUpdateStockModal(productId) {
    const products = JSON.parse(localStorage.getItem('products')) || [];
    const product = products.find(p => p.productId === productId);
    
    if (!product) {
        alert('Product not found');
        return;
    }
    
    selectedProductForStock = product;
    
    document.getElementById('stockProductId').value = product.productId;
    document.getElementById('stockProductName').value = product.productName;
    document.getElementById('currentStock').value = product.stockQuantity;
    document.getElementById('stockAction').value = '';
    document.getElementById('stockQuantity').value = '';
    document.getElementById('newStock').value = '';
    
    document.getElementById('stockModal').style.display = 'block';
}

/**
 * Toggle stock input based on action
 */
function toggleStockInput() {
    const action = document.getElementById('stockAction').value;
    const quantityInput = document.getElementById('stockQuantity');
    const newStockInput = document.getElementById('newStock');
    const currentStock = parseInt(document.getElementById('currentStock').value);
    
    if (!action) {
        quantityInput.value = '';
        newStockInput.value = '';
        return;
    }
    
    // Enable quantity input
    quantityInput.disabled = false;
    
    // Listen for quantity changes
    quantityInput.oninput = function() {
        const quantity = parseInt(this.value) || 0;
        let newStock = currentStock;
        
        switch (action) {
            case 'add':
                newStock = currentStock + quantity;
                break;
            case 'remove':
                newStock = Math.max(0, currentStock - quantity);
                break;
            case 'set':
                newStock = quantity;
                break;
        }
        
        newStockInput.value = newStock;
    };
}

/**
 * Update stock
 */
function updateStock(e) {
    e.preventDefault();
    
    const action = document.getElementById('stockAction').value;
    const quantity = parseInt(document.getElementById('stockQuantity').value);
    const newStock = parseInt(document.getElementById('newStock').value);
    
    if (!action || isNaN(quantity)) {
        alert('Please select action and enter quantity');
        return;
    }
    
    if (newStock < 0) {
        alert('Stock cannot be negative');
        return;
    }
    
    // Update in localStorage
    let products = JSON.parse(localStorage.getItem('products')) || [];
    const product = products.find(p => p.productId === selectedProductForStock.productId);
    
    if (product) {
        product.stockQuantity = newStock;
        localStorage.setItem('products', JSON.stringify(products));
        
        alert('Stock updated successfully!');
        closeStockModal();
        loadInventory();
        updateInventorySummary();
    } else {
        alert('Product not found');
    }
}

/**
 * Close stock modal
 */
function closeStockModal() {
    document.getElementById('stockModal').style.display = 'none';
    selectedProductForStock = null;
}

// Close modal when clicking outside
window.onclick = function(event) {
    const modal = document.getElementById('stockModal');
    if (event.target === modal) {
        closeStockModal();
    }
}