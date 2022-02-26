package threadship;

public abstract class Ship extends Thread {

    public static class ShipDownload extends Ship {
        private final ShipDataBase port;
        private int cargo;

        public ShipDownload(ShipDataBase port, int cargo) {
            this.port = port;
            this.cargo = cargo;
        }
        @Override
        public void run() {
            this.port.add(this.cargo);
        }
    }

    public static class ShipUpload extends Ship {
        private final ShipDataBase port;

        public ShipUpload(ShipDataBase port) {
            this.port = port;
        }
        @Override
        public void run() {
            this.port.del();
        }
    }
}
