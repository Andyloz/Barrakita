/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.barrakita;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author andyloz
 */
public class Programa {
    
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Caja> cajas = new ArrayList<>();
    static ArrayList<Producto> productos = new ArrayList<>();
    
    public static void cargaProductos(List<Caja> cajas, List<Producto> productos) {
        productos.add(new Producto("Toallitas", 2));                  // 0
        productos.add(new Producto("Papel higienico", 2));            // 1
        productos.add(new Producto("Coca-Cola", 1.7));                // 2
        productos.add(new Producto("2 Barras de pan", 1));            // 3
        productos.add(new Producto("Botella de lejia", 2));           // 4
        productos.add(new Producto("Pasta de dientes", 2));           // 5
        productos.add(new Producto("Botella de aceite", 4));          // 6
        productos.add(new Producto("Bolsa de patatas fritas", 2));    // 7
        productos.add(new Producto("Pack de cervezas", 3));           // 8
        productos.add(new Producto("Bolsa de Papa-Delta", 1));        // 9
        productos.add(new Producto("Kikos MisterCorn", 1.5));         // 10
        productos.add(new Producto("Paquete de lentejas", 1.5));      // 11
        productos.add(new Producto("Paquete de garbanzos", 1.5));     // 12
        productos.add(new Producto("Fideos chinos rapidos", 1.5));    // 13
        productos.add(new Producto("Judias de lata litoral", 1.5));   // 14
        productos.add(new Producto("Azucar", 1.5));

        cajas.add(new Caja("Caja 1",
                productos.get(0).clone(),
                productos.get(1).clone(),
                productos.get(2).clone(),
                productos.get(3).clone(),
                productos.get(4).clone(),
                productos.get(5).clone(),
                productos.get(6).clone()));

        cajas.add(new Caja("Caja 2",
                productos.get(7).clone(),
                productos.get(8).clone(),
                productos.get(9).clone(),
                productos.get(10).clone(),
                productos.get(11).clone()));

        cajas.add(new Caja("Caja 3",
                productos.get(7).clone(),
                productos.get(8).clone(),
                productos.get(12).clone(),
                productos.get(13).clone(),
                productos.get(14).clone(),
                productos.get(15).clone()));

        cajas.add(new Caja("Caja 4",
                productos.get(8).clone(),
                productos.get(0).clone(),
                productos.get(1).clone(),
                productos.get(2).clone(),
                productos.get(3).clone(),
                productos.get(4).clone(),
                productos.get(5).clone()));
    }
    
    public static void main(String[] args) {
        while (true) {
            bienvenida();
            
            System.out.println("¿Que quiere hacer?\n\n"
                    + "(1) Comprar\n"
                    + "(2) Salir");
            
            switch(seleccionScInt(1, 2)) {
                case 1:
                    System.out.println("\n");
                    barraquita();
                    break;
                case 2:
                    System.exit(0);
            }
        }
    }

    public static void barraquita() {
        cargaProductos(cajas, productos);
        
        System.out.println("Seleccione una caja. Una vez seleccionada podra comprarla o ver sus productos");
        System.out.println("¡¡¡ Ahorrese 2€ comprando una caja premontada !!!\n");
        Caja caja = seleccionCaja(cajas);
        
        if (caja == null) {
            
        } else {
            
        }
    }
    
    public static void bienvenida() {
        System.out.println("\n\n  ____                       _    _ _        \n"
                + " | __ )  __ _ _ __ _ __ __ _| | _(_) |_ __ _ \n"
                + " |  _ \\ / _` | '__| '__/ _` | |/ / | __/ _` |\n"
                + " | |_) | (_| | |  | | | (_| |   <| | || (_| |\n"
                + " |____/ \\__,_|_|  |_|  \\__,_|_|\\_\\_|\\__\\__,_|\n"
                + "                                             ");
        System.out.println("---------------------------------------------\n");
    }
    
    public static int seleccionScInt(int ini, int fin) {
        if (fin <= ini) {
            throw new IllegalArgumentException(
                    "Fin(" + fin +") mayor o igual que inicio(" + ini + ")");
        }
        
        int opcion;
        String ok = "> ";
        String error = "!! > ";
        String prompt = ok;
        do {
            opcion = ini - 1;
            System.out.print(prompt);
            
            try {
                opcion = sc.nextInt();
            } catch (InputMismatchException e) {
                sc.next();
                prompt = error;
            }
            
            if (opcion < ini || opcion > fin) {
                opcion = ini - 1;
                prompt = error;
            } else {
                prompt = ok;
            }
        } while (opcion == ini - 1);
        
        return opcion;
    }
    
    public static Caja seleccionCaja(List<Caja> cajas) {
        for (int i = 0; i < cajas.size(); i++) {
            Caja caja = cajas.get(i);
            System.out.println("(" + (i+1) + ") " + caja.getNombre());
        }
        System.out.println("(0) Caja personalizada");
        
        
        int opcion = seleccionScInt(0, cajas.size());
        
        if (opcion == 0) {
            return null;
        }
        return cajas.get(opcion-1);
    }
}
