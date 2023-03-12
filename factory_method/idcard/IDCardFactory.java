package factory_method.idcard;
import java.util.*;

import factory_method.framework.*;

public class IDCardFactory extends Factory {
    private List owners = new ArrayList();
    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }
    protected void registerProduct(Product product) {
        owners.add(product);
        IDCard idcard = (IDCard) product;
        idcard.getOwner();
    }
    public List<String> getOwners() {
        return owners;
    }
}
