import Entidad.Producto;

import java.util.Scanner;


public class Main
{
    public static void main(String[] args)
    {
        Integer seleccion;
        Producto producto = new Producto();
        do
        {
            Scanner opcion = new Scanner(System.in);
            System.out.println("Seleccione la Opcion: \n" +
                    "1- Registrar Producto\n" +
                    "2- Buscar Producto\n" +
                    "3- Modificar Producto\n" +
                    "4- Eliminar Producto\n" +
                    "0- Salir\n");
            seleccion = opcion.nextInt();
            switch (seleccion)
            {
                case 1 -> producto.registrarProducto();
                case 2 -> producto.mostrarProducto();
                case 3 -> producto.editarProducto();
                case 4 -> producto.eliminarProducto();
                case 0 -> System.out.println("Gracias Por Utilizar nuestro Sistema...!!!");
            }
        }while(seleccion != 0);


    }
}