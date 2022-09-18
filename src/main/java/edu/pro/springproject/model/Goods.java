package edu.pro.springproject.model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;
        @ApiModel
        @Document
public class Goods {
            @Id
            @ApiModelProperty(value = "ID when saved in database",
                    name = "id",
                    dataType = "UIID",
                    required = false,
                    position = 0)
        private String id;
            @ApiModelProperty(value = "The name of goods when saved in database",
                    name = "name",
                    dataType = "String",
                    required = false,
                    position = 0)
        private String name;
            @ApiModelProperty(value = "Description of our goods ",
                    name = "description",
                    dataType = "String",
                    required = true,
                    position = 0)
        private String description;
            @ApiModelProperty(value = "Code of our goods ",
                    name = "code",
                    dataType = "String",
                    required = true,
                    position = 0)
        private String code;
            @ApiModelProperty(value = "The price  of our goods ",
                    name = "price",
                    dataType = "double",
                    required = false,
                    position = 0)
        private double price;
            @ApiModelProperty(value = "Possibility of delivery for some  goods ",
                    name = "deliveryAble",
                    dataType = "TimeOfDelivery",
                    required = false,
                    position = 0)
        private TimeOfDelivery delivery;
            @ApiModelProperty(value = "Time when we CREATE  our  goods ",
                    name = "createdAt",
                    dataType = "LocalDateTime",
                    required = false,
                    position = 0)
        private LocalDateTime createdAt;
            @ApiModelProperty(value = "Time when we UPDATE  our  goods ",
                    name = "updatedAt",
                    dataType = "LocalDateTime",
                    required = false,
                    position = 0)
        private LocalDateTime updatedAt;

        public Goods(String name, String description, String code, double price, TimeOfDelivery delivery,
                     LocalDateTime createdAt,LocalDateTime updatedAt) {
            this.name = name;
            this.description = description;
            this.code = code;
            this.price = price;
            this.delivery = delivery;
            this.createdAt = createdAt;
            this.updatedAt = updatedAt;
        }

            public Goods(String name, String description, String code, double price, TimeOfDelivery delivery) {
                this.name = name;
                this.description = description;
                this.code = code;
                this.price = price;
                this.delivery = delivery;
            }

            public Goods() {
        }

        public Goods(String id, String name, String description, String code, double price, TimeOfDelivery delivery,
                     LocalDateTime createdAt,LocalDateTime updatedAt) {
            this.id = id;
            this.name = name;
            this.description = description;
            this.code = code;
            this.price = price;
            this.delivery = delivery;
            this.createdAt = createdAt;
            this.updatedAt = updatedAt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public TimeOfDelivery getDelivery() {
                return delivery;
            }
            public void setDelivery(TimeOfDelivery delivery) {
                this.delivery = delivery;
            }
            public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Goods goods = (Goods) o;
            return getId().equals(goods.getId());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId());
        }

        @Override
        public String toString() {
            return "Goods{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", description='" + description + '\'' +
                    ", code='" + code + '\'' +
                    ", price=" + price +
                    ", deliveryAble=" + delivery +
                    ", CreatedAt=" + createdAt +
                    ", UpdatedAt=" + updatedAt +
                    '}';
        }
    }

