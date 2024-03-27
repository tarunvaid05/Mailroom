/*
Tarun Vaidhyanathan
115510562
R02
 */
/**
 * The Package class represents a package with recipient information, arrival date, and weight.
 */
public class Package {
    /** The name of the recipient. */
    String recipient;
    /** The arrival date of the package. */
    int arrivalDate;
    /** The weight of the package. */
    double weight;
    /**
     * Constructs a Package object with the given recipient, arrival date, and weight.
     *
     * @param recipient The name of the recipient.
     * @param arrivalDate The arrival date of the package.
     * @param weight The weight of the package.
     */
    public Package(String recipient,int arrivalDate, double weight){
        this.recipient = recipient;
        this.arrivalDate = arrivalDate;
        this.weight = weight;
    }
    /**
     * Gets the recipient of the package.
     *
     * @return The name of the recipient.
     */
    public String getRecipient(){
        return this.recipient;
    }
    /**
     * Gets the arrival date of the package.
     *
     * @return The arrival date of the package.
     */
    public int getArrivalDate(){
        return this.arrivalDate;
    }
    /**
     * Gets the weight of the package.
     *
     * @return The weight of the package.
     */
    public double getWeight(){
        return this.weight;
    }
    /**
     * Sets the recipient of the package.
     *
     * @param recipient The name of the recipient.
     */
    public void setRecipient(String recipient){
        this.recipient = recipient;
    }
    /**
     * Sets the arrival date of the package.
     *
     * @param arrivalDate The arrival date of the package.
     */
    public void setArrivalDate(int arrivalDate){
        this.arrivalDate = arrivalDate;
    }
    /**
     * Sets the weight of the package.
     *
     * @param weight The weight of the package.
     */
    public void setWeight(double weight){
        this.weight = weight;
    }
    /**
     * Returns a string representation of the package, including recipient and arrival date.
     *
     * @return A string representation of the package.
     */
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("[" + this.getRecipient() + " " + this.getArrivalDate() + "]");
        return str.toString();
    }
}
