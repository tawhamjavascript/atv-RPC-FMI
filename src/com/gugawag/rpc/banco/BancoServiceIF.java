package com.gugawag.rpc.banco;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BancoServiceIF extends Remote {

    double saldo(String conta) throws RemoteException;
    int quantidadeContas() throws RemoteException;
    void criarConta() throws RemoteException;
    void removerConta(String numero) throws RemoteException;
    Conta pesquisarConta(String numero) throws RemoteException;
}
