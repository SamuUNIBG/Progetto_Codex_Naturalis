package Carta;

import Enumerazione.Colore;
import Enumerazione.Simbolo;

public interface InterfacciaCarte3 {
	public abstract Simbolo getSimbolo();
	public abstract Colore getColore();
	public abstract boolean isContataScala();
	public abstract void setContataScala(boolean contataScala);
	public abstract boolean isContataL() ;
	public abstract void setContataL(boolean contataL);
}
