package com.poo.entidadbancomartin.entidades.packcuentas;

import com.poo.entidadbancomartin.entidades.packclientes.ClientesEmpresa;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class CuentaConvertibilidad extends CuentaCorriente {
    private double saldoDolares;

    public CuentaConvertibilidad(int numerocuenta, ClientesEmpresa cliente, double montoautorizado) {
        super(numerocuenta, cliente, montoautorizado);
    }

    public void depositarDolares(double monto) {
        if (monto > 0) {
            this.saldoDolares += monto;
            System.out.println("Depósito exitoso. Nuevo saldo dólares: u$s " + this.saldoDolares);
        } else {
            System.out.println("El monto a depositar debe ser mayor a cero.");
        }
    }

    public void extraerDolares(double monto) {
        if (monto > 0 && this.saldoDolares >= monto) {
            this.saldoDolares -= monto;
            System.out.println("Extracción exitosa. Nuevo saldo dólares: u$s " + this.saldoDolares);
        } else {
            System.out.println("Error: Fondos insuficientes en dólares. No se acepta giro en descubierto.");
        }
    }

    public void convertirPesosADolares(double montoPesos, double tasaConversion) {
        // Validamos que el monto y la tasa sean positivos, y que el saldo en pesos
        // alcance
        if (montoPesos > 0 && tasaConversion > 0 && this.saldo >= montoPesos) {
            this.saldo -= montoPesos;
            double dolaresComprados = montoPesos / tasaConversion;
            this.saldoDolares += dolaresComprados;
            System.out.println("Conversión exitosa. Compraste u$s " + dolaresComprados);
        } else {
            System.out.println("Error: No tenés suficientes pesos en cuenta para realizar la conversión.");
        }
    }

    public void convertirDolaresAPesos(double montoDolares, double tasaConversion) {
        // Validamos que el monto y la tasa sean positivos, y que el saldo en dólares
        // alcance
        if (montoDolares > 0 && tasaConversion > 0 && this.saldoDolares >= montoDolares) {
            this.saldoDolares -= montoDolares;
            double pesosObtenidos = montoDolares * tasaConversion;
            this.saldo += pesosObtenidos;
            System.out.println("Conversión exitosa. Vendiste u$s " + montoDolares + " y obtuviste $" + pesosObtenidos);
        } else {
            System.out.println("Error: No tenés suficientes dólares en cuenta para convertir.");
        }
    }
}
