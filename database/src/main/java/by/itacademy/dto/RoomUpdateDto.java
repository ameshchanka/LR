package by.itacademy.dto;

import by.itacademy.entity.LeaseAd;
import by.itacademy.entity.Room;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomUpdateDto {

    private Room room;
    private LeaseAd leaseAd;

}
