package Entidad;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class Producto
{
    private String nombre;
    private Integer id;
    private Double precio;
    private Integer cantidad;

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Producto(String nombre, Integer id, Double precio, Integer cantidad)
    {
        this.nombre = nombre;
        this.id = id;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    public Producto()
    {
        this.nombre = "";
        this.id = 0;
        this.precio = 0.0;
        this.cantidad = 0;
    }
    public static ArrayList<Producto> productos = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    public void registrarProducto() {
        String nombre;
        double precio;
        int cantidad;

        do {
            System.out.println("Ingrese el nombre del producto: ");
            nombre = sc.nextLine().trim().toLowerCase();
        } while (nombre.isEmpty());

        do {
            System.out.println("Ingrese el precio del producto: ");
            while (!sc.hasNextDouble()) {
                System.out.println("Ingrese un número válido:");
                sc.next();
            }
            precio = sc.nextDouble();
        } while (precio < 0);

        do {
            System.out.println("Ingrese el stock del producto: ");
            while (!sc.hasNextInt()) {
                System.out.println("Ingrese un número válido:");
                sc.next();
            }
            cantidad = sc.nextInt();
        } while (cantidad < 0);
        sc.nextLine(); // limpiar buffer

        int nuevoId = productos.size() + 1;
        Producto prod = new Producto(nombre, nuevoId, precio, cantidad);
        productos.add(prod);

        System.out.println("\n Producto registrado exitosamente:");
        System.out.println("ID: " + prod.getId() +
                "\nNombre: " + prod.getNombre() +
                "\nPrecio: $" + prod.getPrecio() +
                "\nCantidad: " + prod.getCantidad() +
                "\nTotal stock: $" + (prod.getPrecio() * prod.getCantidad()) + "\n");
    }

    public void mostrarProducto() {
        System.out.println("Ingrese el ID del producto a mostrar: ");
        int idBuscado = sc.nextInt();
        sc.nextLine();

        Optional<Producto> prod = productos.stream()
                .filter(p -> p.getId() != null && p.getId().equals(idBuscado))
                .findFirst();

        if (prod.isPresent()) {
            Producto p = prod.get();
            System.out.println("\n Producto encontrado:");
            System.out.println("ID: " + p.getId() +
                    "\nNombre: " + p.getNombre() +
                    "\nPrecio: $" + p.getPrecio() +
                    "\nCantidad: " + p.getCantidad() +
                    "\nTotal stock: $" + (p.getPrecio() * p.getCantidad()) + "\n");
        } else {
            System.out.println("No se encontró ningún producto con ese ID.\n");
        }
    }

    public void editarProducto() {
        System.out.println("Ingrese el ID del producto a editar: ");
        int idBuscado = sc.nextInt();
        sc.nextLine();

        Optional<Producto> prod = productos.stream()
                .filter(p -> p.getId() != null && p.getId().equals(idBuscado))
                .findFirst();

        if (prod.isPresent()) {
            Producto productoEditar = prod.get();

            System.out.println("Ingrese el nuevo nombre del producto: ");
            String nuevoNombre = sc.nextLine();

            double nuevoPrecio;
            do {
                System.out.println("Ingrese el nuevo precio del producto: ");
                while (!sc.hasNextDouble()) {
                    System.out.println("Ingrese un número válido:");
                    sc.next();
                }
                nuevoPrecio = sc.nextDouble();
            } while (nuevoPrecio < 0);

            int nuevoStock;
            do {
                System.out.println("Ingrese el nuevo stock del producto: ");
                while (!sc.hasNextInt()) {
                    System.out.println("Ingrese un número válido:");
                    sc.next();
                }
                nuevoStock = sc.nextInt();
            } while (nuevoStock < 0);
            sc.nextLine();

            productoEditar.setNombre(nuevoNombre);
            productoEditar.setPrecio(nuevoPrecio);
            productoEditar.setCantidad(nuevoStock);

            System.out.println("\nProducto editado correctamente.\n");
        } else {
            System.out.println("No se encontró ningún producto con ese ID.\n");
        }
    }

    public void eliminarProducto() {
        System.out.println("Ingrese el ID del producto a eliminar: ");
        int idBuscado = sc.nextInt();
        sc.nextLine();

        Optional<Producto> prod = productos.stream()
                .filter(p -> p.getId() != null && p.getId().equals(idBuscado))
                .findFirst();

        if (prod.isPresent()) {
            Producto productoAEliminar = prod.get();
            System.out.println("Nombre del producto a eliminar: " + productoAEliminar.getNombre());
            productos.remove(productoAEliminar);
            System.out.println("Producto eliminado exitosamente.\n");
        } else {
            System.out.println("No se encontró ningún producto con ese ID.\n");
        }
    }
}
