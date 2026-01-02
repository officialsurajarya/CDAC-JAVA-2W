/*
===================================
PRODUCT MANAGEMENT MODULE
===================================
Developer: Frontend Team
Purpose: Handle product CRUD operations
Simulates: InventoryService.java from backend
===================================
*/

let editingProductId = null;

/**
 * Load products on page load
 */
document.addEventListener('DOMContentLoaded', function() {
    checkAuth();
    loadProducts();
    
    // Setup form submission
    const productForm = document.getElementById('productForm');
    if (productForm) {
        productForm.addEventListener('submit', handleProductSubmit);
    }
});

/**
 * Load and display all products
 */
function loadProducts() {
    const products = JSON.parse(localStorage.getItem('products')) || [];
    const tableBody = document.getElementById('productsTable');
    
    if (products.length === 0) {
        tableBody.innerHTML = '<tr><td colspan="7" class="empty-message">No products found</td></tr>';
        return;
    }
    
    tableBody.innerHTML = products.map(product => `
        <tr>
            <td>${product.productId}</td>
            <td>${product.productName}</td>
            <td>${product.category}</td>
            <td>₹${parseFloat(product.price).toFixed(2)}</td>
            <td>${product.stockQuantity}</td>
            <td>${product.description || '-'}</td>
            <td class="action-buttons">
                <button onclick="editProduct('${product.productId}')" class="btn btn-sm btn-secondary btn-icon" title="Edit">
                    <svg width="16" height="16" viewBox="0 0 24 24" fill="currentColor">
                        <path d="M3 17.25V21h3.75L17.81 9.94l-3.75-3.75L3 17.25zM20.71 7.04c.39-.39.39-1.02 0-1.41l-2.34-2.34c-.39-.39-1.02-.39-1.41 0l-1.83 1.83 3.75 3.75 1.83-1.83z"/>
                    </svg>
                </button>
                <button onclick="deleteProduct('${product.productId}')" class="btn btn-sm btn-danger btn-icon" title="Delete">
                    <svg width="16" height="16" viewBox="0 0 24 24" fill="currentColor">
                        <path d="M6 19c0 1.1.9 2 2 2h8c1.1 0 2-.9 2-2V7H6v12zM19 4h-3.5l-1-1h-5l-1 1H5v2h14V4z"/>
                    </svg>
                </button>
            </td>
        </tr>
    `).join('');
}

/**
 * Show add product modal
 */
function showAddProductModal() {
    editingProductId = null;
    document.getElementById('modalTitle').textContent = 'Add New Product';
    document.getElementById('productForm').reset();
    
    // Generate next product ID
    const products = JSON.parse(localStorage.getItem('products')) || [];
    const nextId = generateNextProductId(products);
    document.getElementById('productId').value = nextId;
    document.getElementById('productId').readOnly = true;
    
    document.getElementById('productModal').style.display = 'block';
}

/**
 * Generate next product ID
 */
function generateNextProductId(products) {
    if (products.length === 0) return 'P001';
    
    const maxId = products.reduce((max, p) => {
        const num = parseInt(p.productId.substring(1));
        return num > max ? num : max;
    }, 0);
    
    return 'P' + String(maxId + 1).padStart(3, '0');
}

/**
 * Edit product
 */
function editProduct(productId) {
    const products = JSON.parse(localStorage.getItem('products')) || [];
    const product = products.find(p => p.productId === productId);
    
    if (!product) {
        alert('Product not found');
        return;
    }
    
    editingProductId = productId;
    document.getElementById('modalTitle').textContent = 'Edit Product';
    
    // Fill form with product data
    document.getElementById('productId').value = product.productId;
    document.getElementById('productId').readOnly = true;
    document.getElementById('productName').value = product.productName;
    document.getElementById('category').value = product.category;
    document.getElementById('price').value = product.price;
    document.getElementById('stockQuantity').value = product.stockQuantity;
    document.getElementById('description').value = product.description || '';
    
    document.getElementById('productModal').style.display = 'block';
}

/**
 * Handle product form submission
 */
function handleProductSubmit(e) {
    e.preventDefault();
    
    const productData = {
        productId: document.getElementById('productId').value.trim(),
        productName: document.getElementById('productName').value.trim(),
        category: document.getElementById('category').value,
        price: parseFloat(document.getElementById('price').value),
        stockQuantity: parseInt(document.getElementById('stockQuantity').value),
        description: document.getElementById('description').value.trim()
    };
    
    // Validate
    if (!validateProduct(productData)) {
        return;
    }
    
    let products = JSON.parse(localStorage.getItem('products')) || [];
    
    if (editingProductId) {
        // Update existing product
        const index = products.findIndex(p => p.productId === editingProductId);
        if (index !== -1) {
            products[index] = productData;
            alert('Product updated successfully!');
        }
    } else {
        // Add new product
        if (products.find(p => p.productId === productData.productId)) {
            alert('Product ID already exists!');
            return;
        }
        products.push(productData);
        alert('Product added successfully!');
    }
    
    // Save to localStorage
    localStorage.setItem('products', JSON.stringify(products));
    
    // Close modal and reload
    closeModal();
    loadProducts();
}

/**
 * Validate product data
 */
function validateProduct(product) {
    if (!product.productId || !product.productId.match(/^P\d{3}$/)) {
        alert('Product ID must be in format P001, P002, etc.');
        return false;
    }
    
    if (!product.productName) {
        alert('Product name is required');
        return false;
    }
    
    if (!product.category) {
        alert('Category is required');
        return false;
    }
    
    if (product.price <= 0) {
        alert('Price must be greater than 0');
        return false;
    }
    
    if (product.stockQuantity < 0) {
        alert('Stock quantity cannot be negative');
        return false;
    }
    
    return true;
}

/**
 * Delete product
 */
function deleteProduct(productId) {
    if (!confirm('Are you sure you want to delete this product?')) {
        return;
    }
    
    let products = JSON.parse(localStorage.getItem('products')) || [];
    products = products.filter(p => p.productId !== productId);
    
    localStorage.setItem('products', JSON.stringify(products));
    alert('Product deleted successfully!');
    loadProducts();
}

/**
 * Search products
 */
function searchProducts() {
    const searchTerm = document.getElementById('searchInput').value.toLowerCase();
    const products = JSON.parse(localStorage.getItem('products')) || [];
    
    const filtered = products.filter(p => 
        p.productId.toLowerCase().includes(searchTerm) ||
        p.productName.toLowerCase().includes(searchTerm) ||
        p.category.toLowerCase().includes(searchTerm)
    );
    
    const tableBody = document.getElementById('productsTable');
    
    if (filtered.length === 0) {
        tableBody.innerHTML = '<tr><td colspan="7" class="empty-message">No products found</td></tr>';
        return;
    }
    
    tableBody.innerHTML = filtered.map(product => `
        <tr>
            <td>${product.productId}</td>
            <td>${product.productName}</td>
            <td>${product.category}</td>
            <td>₹${parseFloat(product.price).toFixed(2)}</td>
            <td>${product.stockQuantity}</td>
            <td>${product.description || '-'}</td>
            <td class="action-buttons">
                <button onclick="editProduct('${product.productId}')" class="btn btn-sm btn-secondary btn-icon" title="Edit">
                    <svg width="16" height="16" viewBox="0 0 24 24" fill="currentColor">
                        <path d="M3 17.25V21h3.75L17.81 9.94l-3.75-3.75L3 17.25zM20.71 7.04c.39-.39.39-1.02 0-1.41l-2.34-2.34c-.39-.39-1.02-.39-1.41 0l-1.83 1.83 3.75 3.75 1.83-1.83z"/>
                    </svg>
                </button>
                <button onclick="deleteProduct('${product.productId}')" class="btn btn-sm btn-danger btn-icon" title="Delete">
                    <svg width="16" height="16" viewBox="0 0 24 24" fill="currentColor">
                        <path d="M6 19c0 1.1.9 2 2 2h8c1.1 0 2-.9 2-2V7H6v12zM19 4h-3.5l-1-1h-5l-1 1H5v2h14V4z"/>
                    </svg>
                </button>
            </td>
        </tr>
    `).join('');
}

/**
 * Close modal
 */
function closeModal() {
    document.getElementById('productModal').style.display = 'none';
    editingProductId = null;
}

// Close modal when clicking outside
window.onclick = function(event) {
    const modal = document.getElementById('productModal');
    if (event.target === modal) {
        closeModal();
    }
}