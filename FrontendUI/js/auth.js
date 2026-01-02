/*
===================================
AUTHENTICATION MODULE
===================================
Developer: Frontend Team
Purpose: Handle login, logout, and session management
===================================
*/

// Sample user data (simulating users.txt from backend)
const users = [
    { username: 'admin', password: 'admin123', role: 'ADMIN' },
    { username: 'cashier', password: 'cash123', role: 'CASHIER' },
    { username: 'manager', password: 'manager123', role: 'MANAGER' }
];

/**
 * Handle login form submission
 */
document.addEventListener('DOMContentLoaded', function() {
    const loginForm = document.getElementById('loginForm');
    
    if (loginForm) {
        loginForm.addEventListener('submit', function(e) {
            e.preventDefault();
            handleLogin();
        });
    }
    
    // Initialize sample data if not exists
    initializeSampleData();
});

/**
 * Process login authentication
 */
function handleLogin() {
    const username = document.getElementById('username').value.trim();
    const password = document.getElementById('password').value.trim();
    const errorMessage = document.getElementById('errorMessage');
    const errorText = document.getElementById('errorText');
    
    // Clear previous errors
    errorMessage.style.display = 'none';
    
    // Validate inputs
    if (!username || !password) {
        showError('Please enter both username and password');
        return;
    }
    
    // Check credentials
    const user = users.find(u => u.username === username && u.password === password);
    
    if (user) {
        // Store user session
        sessionStorage.setItem('currentUser', JSON.stringify(user));
        sessionStorage.setItem('isLoggedIn', 'true');
        
        // Redirect to dashboard
        window.location.href = 'dashboard.html';
    } else {
        showError('Invalid username or password');
    }
}

/**
 * Display error message
 */
function showError(message) {
    const errorMessage = document.getElementById('errorMessage');
    const errorText = document.getElementById('errorText');
    
    errorText.textContent = message;
    errorMessage.style.display = 'flex';
}

/**
 * Check if user is authenticated
 */
function checkAuth() {
    const isLoggedIn = sessionStorage.getItem('isLoggedIn');
    const currentPage = window.location.pathname.split('/').pop();
    
    if (!isLoggedIn && currentPage !== 'index.html' && currentPage !== '') {
        window.location.href = 'index.html';
        return false;
    }
    
    if (isLoggedIn && (currentPage === 'index.html' || currentPage === '')) {
        window.location.href = 'dashboard.html';
        return false;
    }
    
    // Update user display
    if (isLoggedIn) {
        updateUserDisplay();
    }
    
    return true;
}

/**
 * Update current user display in navbar
 */
function updateUserDisplay() {
    const currentUserElement = document.getElementById('currentUser');
    if (currentUserElement) {
        const user = JSON.parse(sessionStorage.getItem('currentUser'));
        if (user) {
            currentUserElement.textContent = `Welcome, ${user.username} (${user.role})`;
        }
    }
}

/**
 * Logout function
 */
function logout() {
    if (confirm('Are you sure you want to logout?')) {
        sessionStorage.clear();
        window.location.href = 'index.html';
    }
}

/**
 * Initialize sample data in localStorage
 */
function initializeSampleData() {
    // Initialize products if not exists
    if (!localStorage.getItem('products')) {
        const sampleProducts = [
            { productId: 'P001', productName: 'Laptop', category: 'Electronics', price: 45000, stockQuantity: 15, description: 'Dell Inspiron 15 3000 Series' },
            { productId: 'P002', productName: 'Mouse', category: 'Electronics', price: 500, stockQuantity: 50, description: 'Logitech Wireless Mouse' },
            { productId: 'P003', productName: 'Keyboard', category: 'Electronics', price: 1200, stockQuantity: 30, description: 'Mechanical Gaming Keyboard' },
            { productId: 'P004', productName: 'Monitor', category: 'Electronics', price: 8500, stockQuantity: 20, description: '24 inch LED Monitor' },
            { productId: 'P005', productName: 'Headphones', category: 'Electronics', price: 2500, stockQuantity: 25, description: 'Sony WH-1000XM4' },
            { productId: 'P006', productName: 'Printer', category: 'Electronics', price: 12000, stockQuantity: 10, description: 'HP LaserJet Pro' },
            { productId: 'P007', productName: 'USB Cable', category: 'Accessories', price: 150, stockQuantity: 100, description: 'Type-C USB Cable' },
            { productId: 'P008', productName: 'Phone Cover', category: 'Accessories', price: 300, stockQuantity: 80, description: 'Silicone Phone Cover' },
            { productId: 'P009', productName: 'Charger', category: 'Accessories', price: 800, stockQuantity: 45, description: 'Fast Charging Adapter' },
            { productId: 'P010', productName: 'Backpack', category: 'Accessories', price: 1500, stockQuantity: 5, description: 'Laptop Backpack' }
        ];
        localStorage.setItem('products', JSON.stringify(sampleProducts));
    }
    
    // Initialize customers if not exists
    if (!localStorage.getItem('customers')) {
        const sampleCustomers = [
            { customerId: 'C001', customerName: 'Rahul Sharma', phoneNumber: '9876543210', email: 'rahul.sharma@email.com', totalPurchaseAmount: 0 },
            { customerId: 'C002', customerName: 'Priya Singh', phoneNumber: '9876543211', email: 'priya.singh@email.com', totalPurchaseAmount: 0 },
            { customerId: 'C003', customerName: 'Amit Kumar', phoneNumber: '9876543212', email: 'amit.kumar@email.com', totalPurchaseAmount: 0 },
            { customerId: 'C004', customerName: 'Sneha Patel', phoneNumber: '9876543213', email: 'sneha.patel@email.com', totalPurchaseAmount: 0 },
            { customerId: 'C005', customerName: 'Vijay Reddy', phoneNumber: '9876543214', email: 'vijay.reddy@email.com', totalPurchaseAmount: 0 }
        ];
        localStorage.setItem('customers', JSON.stringify(sampleCustomers));
    }
    
    // Initialize bills if not exists
    if (!localStorage.getItem('bills')) {
        localStorage.setItem('bills', JSON.stringify([]));
    }
}

/**
 * Get current user
 */
function getCurrentUser() {
    return JSON.parse(sessionStorage.getItem('currentUser'));
}

/**
 * Check if user has admin role
 */
function isAdmin() {
    const user = getCurrentUser();
    return user && user.role === 'ADMIN';
}

// Auto-check authentication on page load
if (document.readyState === 'loading') {
    document.addEventListener('DOMContentLoaded', checkAuth);
} else {
    checkAuth();
}