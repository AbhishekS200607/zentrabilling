# Zentra - Complete Inventory Management & Billing System

## Overview
Zentra is a comprehensive full-stack inventory management and billing system built with Spring Boot backend and modern HTML/JavaScript frontend. It provides complete business management capabilities including inventory tracking, customer management, billing, supplier analytics, and financial reporting.

## Technology Stack

### Backend
- **Framework**: Spring Boot 3.2.0
- **Language**: Java 21
- **Database**: MySQL 8.0
- **ORM**: JPA/Hibernate
- **Dependencies**: Spring Data JPA, Spring Web, Validation, Lombok, MySQL Connector

### Frontend
- **Core**: HTML5, Vanilla JavaScript (ES6+)
- **Styling**: Tailwind CSS 3.x
- **Icons**: Ionicons 7.1.0
- **PDF Generation**: jsPDF 2.5.1
- **Design**: Single Page Application with dark theme

## Features

### 1. Dashboard Analytics
- Real-time revenue tracking (daily/monthly)
- Profit calculations
- Low stock alerts
- Business performance metrics

### 2. Advanced Inventory Management
- Product CRUD with barcode support
- Dual pricing (buying/selling price)
- Stock level monitoring with alerts
- Category and brand management
- Profit margin tracking

### 3. Modern Billing System
- POS-like interface with product search
- Real-time product search by name/barcode
- Dynamic invoice calculations
- Walk-in customer support
- Professional PDF invoice generation
- Multiple payment methods

### 4. Customer Relationship Management
- Complete customer database
- Quick customer addition during billing
- Purchase history tracking
- Search functionality

### 5. Supplier Analytics
- Product tracking per supplier
- Performance metrics
- Profit analysis by supplier
- Complete vendor management

### 6. Financial Management
- Expense tracking with categories
- Revenue vs expense analysis
- Profit calculations
- Business intelligence reporting

## Setup Instructions

### Prerequisites
- Java 21
- MySQL 8.0
- Maven 3.6+

### Database Setup
1. Install MySQL 8.0
2. Create database (auto-created by application)
3. Update credentials in `application.properties`

### Application Setup
1. Clone the repository
2. Update database credentials in `src/main/resources/application.properties`
3. Run the application:
   ```bash
   mvn spring-boot:run
   ```
4. Access the application at `http://localhost:8080`

### Configuration
- Default database: `zentra_inventory`
- Default port: `8080`
- Default tax rate: `18%`

## API Endpoints

### Products
- `GET /api/products` - Get all products
- `POST /api/products` - Create product
- `PUT /api/products/{id}` - Update product
- `DELETE /api/products/{id}` - Delete product
- `GET /api/products/search?q={query}` - Search products
- `GET /api/products/low-stock` - Get low stock products

### Customers
- `GET /api/customers` - Get all customers
- `POST /api/customers` - Create customer
- `PUT /api/customers/{id}` - Update customer
- `DELETE /api/customers/{id}` - Delete customer

### Invoices
- `GET /api/invoices` - Get all invoices
- `POST /api/invoices` - Create invoice
- `GET /api/invoices/{id}` - Get invoice details

### Suppliers
- `GET /api/suppliers` - Get all suppliers
- `POST /api/suppliers` - Create supplier
- `GET /api/suppliers/{id}/analytics` - Get supplier analytics

### Expenses
- `GET /api/expenses` - Get all expenses
- `POST /api/expenses` - Create expense

### Dashboard
- `GET /api/dashboard/stats` - Get dashboard statistics

## Key Features

### Billing Workflow
1. Select/add customer
2. Search and add products
3. Automatic calculations
4. Generate professional PDF invoices

### Inventory Features
- Buying price vs selling price tracking
- Automatic profit calculations
- Low stock alerts with color coding
- Barcode support

### Business Intelligence
- Revenue and profit tracking
- Expense categorization
- Supplier performance analytics
- Real-time dashboard metrics

## Usage

### Adding Products
1. Go to Inventory section
2. Click "Add Product"
3. Enter product details including buying/selling prices
4. Set stock levels and thresholds

### Creating Invoices
1. Go to Billing section
2. Click "Create Invoice"
3. Select customer or use walk-in
4. Search and add products
5. Review totals and create invoice
6. Download PDF if needed

### Managing Expenses
1. Go to Expenses section
2. Add business expenses with categories
3. Track spending patterns
4. View expense analytics on dashboard

### Supplier Analytics
1. Go to Suppliers section
2. Add suppliers and link products
3. View product portfolio per supplier
4. Track profitability by supplier

## Business Configuration
- Update business details in Settings
- Configure default tax rates
- Set up business information for invoices

## Security Features
- CORS enabled for frontend integration
- Input validation on all forms
- Error handling with user feedback
- Transaction management for data consistency

This system provides a complete business solution for small to medium enterprises requiring comprehensive inventory and billing management.