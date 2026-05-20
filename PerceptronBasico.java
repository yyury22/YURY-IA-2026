public class Main {
    public static void main(String[] args) {
        
        double[][] x = {
            {1.0, 0.0, 0.0},
            {1.0, 0.0, 1.0},
            {1.0, 1.0, 0.0},
            {1.0, 1.0, 1.0}
        };
        
        int[] yEsperado = {0, 0, 1, 1};
        String[] nomes = {"Joãozinho", "Huguinho", "Zezinho", "Luizinho"};
        
        double[] w = {0.0, 0.0, 0.0};
        double alpha = 0.1;
        int totalCiclos = 2;
        
        for (int ciclo = 1; ciclo <= totalCiclos; ciclo++) {
            System.out.println("\n=== CICLO " + ciclo + " ===");
            
            for (int i = 0; i < x.length; i++) {
                
                double u = 0;
                for (int j = 0; j < w.length; j++) {
                    u += x[i][j] * w[j];
                }
                
                int yPrevisto = (u > 0) ? 1 : 0;
                
                int erro = yEsperado[i] - yPrevisto;
                
                if (erro != 0) {
                    for (int j = 0; j < w.length; j++) {
                        w[j] = w[j] + alpha * erro * x[i][j];
                        w[j] = Math.round(w[j] * 100.0) / 100.0;
                    }
                }
                
                System.out.printf("%-10s | Saída Real: %d | u: %3.1f | Saída Obtida: %d | Erro: %2d | Novos Pesos: [%.1f, %.1f, %.1f]\n",
                        nomes[i], yEsperado[i], u, yPrevisto, erro, w[0], w[1], w[2]);
            }
        }
    }
}