import { Component, OnInit } from '@angular/core';
import { ApiService } from '../services/api.service';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [],
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css'],
})
export class DashboardComponent implements OnInit {
  categories: any[] = [];
  products: any[] = [];
  clients: any[] = [];
  suppliers: any[] = [];
  purchases: any[] = [];
  orders: any[] = [];
  orderDetails: any[] = [];

  constructor(private apiService: ApiService) { }

  ngOnInit(): void {
    this.loadCategories();
    this.loadProducts();
    this.loadClients();
    this.loadSuppliers();
    this.loadPurchases();
    this.loadOrders();
    this.loadOrderDetails();
  }

  loadCategories(): void {
    this.apiService.getCategories().subscribe({
      next: (data) => (this.categories = data || []),
      error: (error) => console.error('Error al cargar categorías:', error),
    });
  }

  loadProducts(): void {
    this.apiService.getProducts().subscribe({
      next: (data) => (this.products = data || []),
      error: (error) => console.error('Error al cargar productos:', error),
    });
  }

  loadClients(): void {
    this.apiService.getClients().subscribe({
      next: (data) => (this.clients = data || []),
      error: (error) => console.error('Error al cargar clientes:', error),
    });
  }

  loadSuppliers(): void {
    this.apiService.getSuppliers().subscribe({
      next: (data) => (this.suppliers = data || []),
      error: (error) => console.error('Error al cargar proveedores:', error),
    });
  }

  loadPurchases(): void {
    this.apiService.getPurchases().subscribe({
      next: (data) => (this.purchases = data || []),
      error: (error) => console.error('Error al cargar compras:', error),
    });
  }

  loadOrders(): void {
    this.apiService.getOrders().subscribe({
      next: (data) => (this.orders = data || []),
      error: (error) => console.error('Error al cargar pedidos:', error),
    });
  }

  loadOrderDetails(): void {
    this.apiService.getOrderDetails().subscribe({
      next: (data) => (this.orderDetails = data || []),
      error: (error) => console.error('Error al cargar detalles de pedido:', error),
    });
  }
}