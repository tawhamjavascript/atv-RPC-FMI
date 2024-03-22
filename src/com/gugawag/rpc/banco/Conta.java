package com.gugawag.rpc.banco;

import java.io.Serializable;

public record Conta(String numero, double saldo) implements Serializable {
}
