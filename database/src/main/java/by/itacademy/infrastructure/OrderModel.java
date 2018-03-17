package by.itacademy.infrastructure;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Getter
@Service
@NoArgsConstructor
public class OrderModel {

    private Map<String, Boolean> orderMap = new HashMap<>();

}
