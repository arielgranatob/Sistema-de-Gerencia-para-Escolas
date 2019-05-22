package escola;

public class Escola {

    public static void main(String[] args) {
        Escola escola = new Escola();
        escola.menu();
    }

    private void menu() {
        JFrameEscola myFrameEscola = new JFrameEscola();
        myFrameEscola.setVisible(true);
    }

}
