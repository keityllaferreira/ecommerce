package entity;

import java.util.Date;
import java.util.Objects;

public class Product { //representa a tabela products do banco de dados

    int id;
    int companyId;
    int codeId;
    String productName;
    double value;
    String productType;
    String productDescription;
    String productImage;
    Date creationDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && companyId == product.companyId && codeId == product.codeId && Double.compare(product.value, value) == 0 && Objects.equals(productName, product.productName) && Objects.equals(productType, product.productType) && Objects.equals(productDescription, product.productDescription) && Objects.equals(productImage, product.productImage) && Objects.equals(creationDate, product.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyId, codeId, productName, value, productType, productDescription, productImage, creationDate);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", companyId=" + companyId +
                ", codeId=" + codeId +
                ", productName='" + productName + '\'' +
                ", value=" + value +
                ", productType='" + productType + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productImage='" + productImage + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }


}
