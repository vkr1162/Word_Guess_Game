import javax.swing.JFrame;

import view.MenuScreen;

class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocation(400, 100);
        window.setTitle("Project1: Word Guess Game");
        var menu = new MenuScreen(window);
        menu.init();
        window.pack();
        window.setVisible(true);
    }
}