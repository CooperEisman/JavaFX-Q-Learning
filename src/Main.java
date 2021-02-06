/*
Code by Cooper Eisman
Created: 02/05/2021
Last Modified: 02/05/2021
*/

class Main {
    //Callable Main value, allows for synchronized runtime processing
    public static Main main = null;

    //Starts Program
    public static void main(String[] args) {
        main = new Main();
        View v = new View();
    }
}
