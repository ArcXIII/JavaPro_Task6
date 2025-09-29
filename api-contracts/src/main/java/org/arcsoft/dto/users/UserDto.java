package org.arcsoft.dto.users;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserDto extends UserShortDto {
    private List<ProductDto> products;

    public UserDto(Long id, String username, List<ProductDto> products) {
        super(id, username);
        this.products = products;
    }
}
