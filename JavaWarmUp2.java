package assn02;
import java.util.Scanner;
import java.text.DecimalFormat;
public class JavaWarmUp2 {
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("How many entries?");
        int entryTotal = in.nextInt();
        EntryData[] entryList = new EntryData[entryTotal];
        System.out.println("Please name the information for these " + entryTotal + " entries.");
        for (int i = 0; i < entryTotal; i++) {
            EntryData presentEntry = new EntryData();
            presentEntry._date = in.next();
            presentEntry._time = in.next();
            presentEntry._category = in.next();
            presentEntry._fee = in.nextFloat();
            presentEntry._quantity = in.nextInt();
            presentEntry._totalTime = in.nextFloat();
            presentEntry._cost = in.nextInt();
            entryList[i] = presentEntry;
        }
        int maxIndex = getMaxPriceIndex(entryList);
        System.out.println("Highest per unit assembling fee: \n\tWhen: " + entryList[maxIndex]._date + " " + entryList[maxIndex]._time + "\n\tCategory: " + entryList[maxIndex]._category + "\n\tPrice: " + entryList[maxIndex]._fee);
        int lowestIndex = getLowestPriceIndex(entryList);
        System.out.println("Lowest per unit assembling fee: \n\tWhen: " + entryList[lowestIndex]._date + " " + entryList[lowestIndex]._time + "\n\tCategory: " + entryList[lowestIndex]._category + "\n\tPrice: " + entryList[lowestIndex]._fee);
        System.out.println(("Statistic of phone\n\tQuantity: " + phoneQuantity(entryList)) + "\n\tAverage Assembling fee: " + df.format(phoneTotalFee(entryList) / phoneQuantity(entryList)) + "\n\tAverage Net Profit: " + df.format((phoneTotalFee(entryList) - phoneCost(entryList))/phoneQuantity(entryList)));
        System.out.println("Statistic of laptop\n\tQuantity: " + laptopQuantity(entryList) + "\n\tAverage Assembling fee: " + df.format(laptopTotalFee(entryList)/laptopQuantity(entryList)) + "\n\tAverage Net Profit: " + df.format((laptopTotalFee(entryList) - laptopCost(entryList))/laptopQuantity(entryList)));
        System.out.println("Statistic of smart_watch\n\tQuantity: " + watchQuantity(entryList) + "\n\tAverage Assembling fee: " + df.format(watchTotalFee(entryList) / watchQuantity(entryList)) + "\n\tAverage Net Profit: " + df.format((watchTotalFee(entryList) - watchCost(entryList))/watchQuantity(entryList)));
    }


    public static int getMaxPriceIndex(EntryData[] arrayName) {
        double maxAssemblingFee = 0.0;
        int maxPriceIndex = 0;
        for (int i = 0; i < arrayName.length; i++) {
            if (arrayName[i]._fee >= maxAssemblingFee) {
                maxAssemblingFee = arrayName[i]._fee;
                maxPriceIndex = i;
            }
        }
        return maxPriceIndex;
    }

    public static int getLowestPriceIndex(EntryData[] arrayName) {
        double lowestAssemblingFee = 100000.0;
        int lowestPriceIndex = 0;
        for (int i = 0; i < arrayName.length; i++) {
            if (arrayName[i]._fee <= lowestAssemblingFee) {
                lowestAssemblingFee = arrayName[i]._fee;
                lowestPriceIndex = i;
            }
        }
        return lowestPriceIndex;
    }

    public static int phoneQuantity(EntryData[] arrayName) {
        int quantity = 0;
        for (int i = 0; i < arrayName.length; i++) {
            if (arrayName[i]._category.equals(("phone"))) {
                quantity += arrayName[i]._quantity;
            }
        }
        return quantity;
    }

    public static int laptopQuantity(EntryData[] arrayName) {
        int quantity = 0;
        for (int i = 0; i < arrayName.length; i++) {
            if (arrayName[i]._category.equals("laptop")) {
                quantity += arrayName[i]._quantity;
            }
        }
        return quantity;
    }

    public static int watchQuantity(EntryData[] arrayName) {
        int quantity = 0;
        for (int i = 0; i < arrayName.length; i++) {
            if (arrayName[i]._category.equals("smart_watch")) {
                quantity += arrayName[i]._quantity;
            }
        }
        return quantity;
    }

    public static float phoneTotalFee(EntryData[] arrayName) {
        float totalFee = 0;
        for (int i = 0; i < arrayName.length; i++) {
            if (arrayName[i]._category.equals("phone")) {
                totalFee += (arrayName[i]._fee * arrayName[i]._quantity);
            }
        }
        return totalFee;

    }

    public static float watchTotalFee(EntryData[] arrayName) {
        float totalFee = 0;
        for (int i = 0; i < arrayName.length; i++) {
            if (arrayName[i]._category.equals("smart_watch")) {
                totalFee += (arrayName[i]._fee * arrayName[i]._quantity);
            }
        }
        return totalFee;

    }

    public static float laptopTotalFee(EntryData[] arrayName) {
        float totalFee = 0;
        for (int i = 0; i < arrayName.length; i++) {
            if (arrayName[i]._category.equals("laptop")) {
                totalFee += (arrayName[i]._fee * arrayName[i]._quantity);
            }
        }
        return totalFee;
    }
    public static int phoneCost(EntryData[] arrayName){
        int cost = 0;
        for (int i = 0; i < arrayName.length; i++){
            if (arrayName[i]._category.equals("phone")) {
                cost += ((arrayName[i]._cost) + (arrayName[i]._totalTime * 16));
            }
        }
        return cost;
    }
    public static int laptopCost(EntryData[] arrayName){
        int cost = 0;
        for (int i = 0; i < arrayName.length; i++){
            if (arrayName[i]._category.equals("laptop")) {
                cost += ((arrayName[i]._cost) + (arrayName[i]._totalTime * 16));
            }
        }
        return cost;
    }
    public static int watchCost(EntryData[] arrayName){
        int cost = 0;
        for (int i = 0; i < arrayName.length; i++){
            if (arrayName[i]._category.equals("smart_watch")) {
                cost += ((arrayName[i]._cost) + (arrayName[i]._totalTime * 16));
            }
        }
        return cost;
    }


}





