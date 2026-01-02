/*
===================================
BILLING MODULE
===================================
Developer: Frontend Team
Purpose: Handle billing operations and invoice generation
Simulates: BillingService.java from backend
===================================
*/

let billItems = [];
let subtotal = 0;
let gst = 0;
let totalAmount = 0;
const GST_RATE = 0.18; // 18% GST

/**
 * Load on page ready
 */
document.addEventListener('DOMContentLoaded', function() {
    checkAuth();
    loadProductsForBilling();
});

/**
 * Load products into select dropdown
 */
function loadProductsForBilling() {
    const products = JSON.parse(localStorage.getItem('products')) || [];
    const select = document.getElementById('billProductId');
    
    select.innerHTML = '<option value="">Select Product</option>';
    
    products.forEach(product => {
        if (product.stockQuantity > 0) {
            const option = document.createElement('option');
            option.value = product.productId;
            option.textContent = `${product.productName} (₹${product.price}) - Stock: ${product.stockQuantity}`;
            option.dataset.price = product.price;
            option.dataset.stock = product.stockQuantity;
            option.dataset.name = product.productName;
            select.appendChild(option);
        }
    });
}

/**
 * Update product price when product is selected
 */
function updateProductPrice() {
    const select = document.getElementById('billProductId');
    const selectedOption = select.options[select.selectedIndex];
    const priceInput = document.getElementById('productPrice');
    
    if (selectedOption.value) {
        priceInput.value = selectedOption.dataset.price;
    } else {
        priceInput.value = '';
    }
}

/**
 * Add product to bill
 */
function addProductToBill(e) {
    e.preventDefault();
    
    const productSelect = document.getElementById('billProductId');
    const selectedOption = productSelect.options[productSelect.selectedIndex];
    const quantity = parseInt(document.getElementById('productQuantity').value);
    
    if (!selectedOption.value) {
        alert('Please select a product');
        return;
    }
    
    const productId = selectedOption.value;
    const productName = selectedOption.dataset.name;
    const price = parseFloat(selectedOption.dataset.price);
    const availableStock = parseInt(selectedOption.dataset.stock);
    
    // Check stock
    if (quantity > availableStock) {
        alert(`Insufficient stock! Only ${availableStock} units available.`);
        return;
    }
    
    // Check if product already in bill
    const existingItem = billItems.find(item => item.productId === productId);
    if (existingItem) {
        const newQuantity = existingItem.quantity + quantity;
        if (newQuantity > availableStock) {
            alert(`Cannot add. Total would exceed available stock of ${availableStock} units.`);
            return;
        }
        existingItem.quantity = newQuantity;
        existingItem.itemTotal = existingItem.quantity * existingItem.unitPrice;
    } else {
        billItems.push({
            productId: productId,
            productName: productName,
            quantity: quantity,
            unitPrice: price,
            itemTotal: quantity * price
        });
    }
    
    // Reset form
    document.getElementById('addProductForm').reset();
    document.getElementById('productPrice').value = '';
    
    // Update display
    updateBillDisplay();
}

/**
 * Update bill display
 */
function updateBillDisplay() {
    const tableBody = document.getElementById('billItemsTable');
    
    if (billItems.length === 0) {
        tableBody.innerHTML = '<tr><td colspan="5" class="empty-message">No items added yet</td></tr>';
        subtotal = 0;
        gst = 0;
        totalAmount = 0;
    } else {
        tableBody.innerHTML = billItems.map((item, index) => `
            <tr>
                <td>${item.productName}</td>
                <td>₹${item.unitPrice.toFixed(2)}</td>
                <td>${item.quantity}</td>
                <td>₹${item.itemTotal.toFixed(2)}</td>
                <td>
                    <button onclick="removeFromBill(${index})" class="btn btn-sm btn-danger btn-icon" title="Remove">
                        <svg width="14" height="14" viewBox="0 0 24 24" fill="currentColor">
                            <path d="M19 6.41L17.59 5 12 10.59 6.41 5 5 6.41 10.59 12 5 17.59 6.41 19 12 13.41 17.59 19 19 17.59 13.41 12z"/>
                        </svg>
                    </button>
                </td>
            </tr>
        `).join('');
        
        // Calculate totals
        subtotal = billItems.reduce((sum, item) => sum + item.itemTotal, 0);
        gst = subtotal * GST_RATE;
        totalAmount = subtotal + gst;
    }
    
    // Update summary
    document.getElementById('subtotal').textContent = '₹' + subtotal.toFixed(2);
    document.getElementById('gst').textContent = '₹' + gst.toFixed(2);
    document.getElementById('totalAmount').textContent = '₹' + totalAmount.toFixed(2);
}

/**
 * Remove item from bill
 */
function removeFromBill(index) {
    if (confirm('Remove this item from bill?')) {
        billItems.splice(index, 1);
        updateBillDisplay();
    }
}

/**
 * Reset bill
 */
function resetBill() {
    if (billItems.length > 0 && !confirm('Are you sure you want to reset the bill?')) {
        return;
    }
    
    billItems = [];
    document.getElementById('customerForm').reset();
    document.getElementById('addProductForm').reset();
    document.getElementById('productPrice').value = '';
    updateBillDisplay();
}

/**
 * Generate invoice
 */
function generateInvoice() {
    // Validate customer details
    const customerId = document.getElementById('customerId').value.trim();
    const customerName = document.getElementById('customerName').value.trim();
    
    if (!customerId || !customerName) {
        alert('Please enter customer details');
        return;
    }
    
    if (billItems.length === 0) {
        alert('Please add at least one product to the bill');
        return;
    }
    
    // Get current user
    const user = getCurrentUser();
    const cashierName = user ? user.username : 'Unknown';
    
    // Generate bill ID
    const bills = JSON.parse(localStorage.getItem('bills')) || [];
    const billId = generateBillId(bills);
    
    // Get current date and time
    const now = new Date();
    const billDate = now.toLocaleString('en-IN', {
        day: '2-digit',
        month: '2-digit',
        year: 'numeric',
        hour: '2-digit',
        minute: '2-digit',
        second: '2-digit'
    });
    
    // Create bill object
    const bill = {
        billId: billId,
        customerId: customerId,
        customerName: customerName,
        cashierName: cashierName,
        billDate: billDate,
        items: [...billItems],
        subtotal: subtotal,
        gstAmount: gst,
        totalAmount: totalAmount
    };
    
    // Update product stock
    updateProductStock();
    
    // Save bill
    bills.push(bill);
    localStorage.setItem('bills', JSON.stringify(bills));
    
    // Update customer purchase amount
    updateCustomerPurchase(customerId, totalAmount);
    
    // Display invoice
    displayInvoice(bill);
}

/**
 * Generate bill ID
 */
function generateBillId(bills) {
    if (bills.length === 0) return 'B0001';
    
    const maxId = bills.reduce((max, b) => {
        const num = parseInt(b.billId.substring(1));
        return num > max ? num : max;
    }, 0);
    
    return 'B' + String(maxId + 1).padStart(4, '0');
}

/**
 * Update product stock after billing
 */
function updateProductStock() {
    let products = JSON.parse(localStorage.getItem('products')) || [];
    
    billItems.forEach(item => {
        const product = products.find(p => p.productId === item.productId);
        if (product) {
            product.stockQuantity -= item.quantity;
        }
    });
    
    localStorage.setItem('products', JSON.stringify(products));
}

/**
 * Update customer purchase amount
 */
function updateCustomerPurchase(customerId, amount) {
    let customers = JSON.parse(localStorage.getItem('customers')) || [];
    const customer = customers.find(c => c.customerId === customerId);
    
    if (customer) {
        customer.totalPurchaseAmount = (parseFloat(customer.totalPurchaseAmount) || 0) + amount;
        localStorage.setItem('customers', JSON.stringify(customers));
    }
}

/**
 * Display invoice in modal
 */
function displayInvoice(bill) {
    const invoiceContent = document.getElementById('invoiceContent');
    
    invoiceContent.innerHTML = `
        <div class="invoice-header">
            <h1>RETAIL POS SYSTEM</h1>
            <p>TAX INVOICE</p>
        </div>
        
        <div class="invoice-info">
            <div>
                <p><strong>Bill ID:</strong> ${bill.billId}</p>
                <p><strong>Date & Time:</strong> ${bill.billDate}</p>
            </div>
            <div>
                <p><strong>Customer ID:</strong> ${bill.customerId}</p>
                <p><strong>Customer Name:</strong> ${bill.customerName}</p>
                <p><strong>Cashier:</strong> ${bill.cashierName}</p>
            </div>
        </div>
        
        <table class="data-table" style="margin-bottom: 20px;">
            <thead>
                <tr>
                    <th>Product</th>
                    <th>Qty</th>
                    <th>Price (₹)</th>
                    <th>Total (₹)</th>
                </tr>
            </thead>
            <tbody>
                ${bill.items.map(item => `
                    <tr>
                        <td>${item.productName}</td>
                        <td>${item.quantity}</td>
                        <td>₹${item.unitPrice.toFixed(2)}</td>
                        <td>₹${item.itemTotal.toFixed(2)}</td>
                    </tr>
                `).join('')}
            </tbody>
        </table>
        
        <div style="text-align: right; padding: 20px; background: var(--light-gray); border-radius: 8px;">
            <p style="margin-bottom: 10px;"><strong>Subtotal:</strong> ₹${bill.subtotal.toFixed(2)}</p>
            <p style="margin-bottom: 10px;"><strong>GST (18%):</strong> ₹${bill.gstAmount.toFixed(2)}</p>
            <hr style="margin: 10px 0; border: 1px solid var(--border-color);">
            <p style="font-size: 18px;"><strong>Total Amount:</strong> ₹${bill.totalAmount.toFixed(2)}</p>
        </div>
        
        <div style="text-align: center; margin-top: 30px; color: var(--text-light);">
            <p>Thank you for shopping with us!</p>
            <p style="font-size: 12px;">This is a computer-generated invoice</p>
        </div>
    `;
    
    // Show modal
    document.getElementById('invoiceModal').style.display = 'block';
    
    // Reset bill after showing invoice
    billItems = [];
    document.getElementById('customerForm').reset();
    updateBillDisplay();
    
    // Reload products (stock updated)
    loadProductsForBilling();
}

/**
 * Close invoice modal
 */
function closeInvoiceModal() {
    document.getElementById('invoiceModal').style.display = 'none';
}

/**
 * Print invoice
 */
function printInvoice() {
    window.print();
}

// Close modal when clicking outside
window.onclick = function(event) {
    const modal = document.getElementById('invoiceModal');
    if (event.target === modal) {
        closeInvoiceModal();
    }
}