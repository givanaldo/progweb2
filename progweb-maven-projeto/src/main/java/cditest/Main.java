package cditest;

public class Main {
    
    public static void main(String[] args) {
        
    		Pedidos pedidos = new Pedidos();
        
        RelatorioService relatorioService = 
        		new RelatorioService(pedidos);  
        
        System.out.println(relatorioService.totalPedidosMesAtual());
    }

}