public class cellphone {
    private double storage;
    private String phoneBrand;
    private boolean canTakePictures;
    private double phonePrice;

    public cellphone() {
        storage = 0;
        phoneBrand = "Unknown";
        canTakePictures = true;
        phonePrice = 0;
    }

    public cellphone(double storage, boolean canTakePictures, double phonePrice) {
        this.storage = storage;
        this.canTakePictures = canTakePictures;
        this.phonePrice = phonePrice;
        this.phoneBrand = "Unknown";
    }

    public void setCanTakePictures(String canTakePictures) {
        this.canTakePictures = canTakePictures.equals("y");
    }

    public boolean getCanTakePictures() {
        return canTakePictures;
    }

    public double getStorage() {
        if (storage < 0) {
            throw new IllegalArgumentException("Storage cannot be negative.");
        }
        return storage;
    }

    public double getPhonePrice() {
        if (phonePrice < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        return phonePrice;
    }

    public void defineBrand() {
        if (storage >= 512) {
            if (canTakePictures) {
                if (phonePrice > 800) {
                    phoneBrand = "iPhone";
                } else if (phonePrice >= 600) {
                    phoneBrand = "Samsung";
                } else {
                    phoneBrand = "Pixel";
                }
            } else {
                phoneBrand = "Unknown Brand";
            }
        } else {
            phoneBrand = "Nokia";
        }
    }

    public String getPhoneBrand() {
        return phoneBrand;
    }

    public String toString() {

        if(canTakePictures)
            return "Your cellphone has a storage of "+storage+"GB "+"costs "+phonePrice+"$ and can take pictures. Considering all factors, your cellphone's brand might be" +phoneBrand;
        else return "Your cellphone has a storage of "+storage+"GB "+"costs "+phonePrice+"$ and can take pictures. Considering all factors, your cellphone's brand might be" +phoneBrand;

    }
}
