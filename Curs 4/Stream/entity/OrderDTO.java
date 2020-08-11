package Stream.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OrderDTO {

    public BigDecimal totalPrice;
    public LocalDate creationDate;

    public OrderDTO() {
    }

	/*
	public OrderDto(BigDecimal totalPrice, LocalDate creationDate) {
		this.totalPrice = totalPrice;
		this.creationDate = creationDate;
	}
	*/
}
