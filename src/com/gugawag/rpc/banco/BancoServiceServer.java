package com.gugawag.rpc.banco;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;


public class BancoServiceServer extends UnicastRemoteObject implements BancoServiceIF {

    private List<Conta> saldoContas;


    public BancoServiceServer() throws RemoteException {
        saldoContas = new ArrayList<Conta>();
        saldoContas.add(new Conta("1", 100.0));
        saldoContas.add(new Conta("2", 156.0));
        saldoContas.add(new Conta("3", 950.0));
    }

    @Override
    public double saldo(String conta) throws RemoteException {

        Conta c = pesquisarConta(conta);
        if(c != null) {
            return c.saldo();
        } else {
            return -1;
        }
    }

    @Override
    public int quantidadeContas() throws RemoteException {
        return saldoContas.size();
    }

    @Override
    public void criarConta() throws RemoteException {
        String id = String.valueOf(saldoContas.size() + 1);

        saldoContas.add(new Conta(id, 0.0));
    }

    public Conta pesquisarConta(String numero) throws RemoteException {
        Conta conta = null;
        for(Conta c : saldoContas) {
            if(c.numero().equals(numero)) {
                conta = c;
                break;
            }
        }
        return conta;
    }

    public void removerConta(String numero) throws RemoteException {
        Conta conta = pesquisarConta(numero);
        if(conta != null) {
            saldoContas.remove(conta);
        }
    }


















}
