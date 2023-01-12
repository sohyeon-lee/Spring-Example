package io.namoosori.travelclub.web.store.jpastore.jpo;

import com.fasterxml.jackson.databind.util.BeanUtil;
import io.namoosori.travelclub.web.aggregate.club.TravelClub;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "TRAVEL_CLUB")
public class TravelClubJpo {

    @Id
    private String id;
    private String name;
    private String intro;
    private long foundationTime;

    // dto -> entity
    public TravelClubJpo(TravelClub travelClub) {
//        this.id = travelClub.getId();
//        this.name = travelClub.getName();
//        this.intro = travelClub.getIntro();
//        this.foundationTime = travelClub.getFoundationTime();

        BeanUtils.copyProperties(travelClub, this);
    }

    // entity -> dto
    public TravelClub toDomain() {
        TravelClub travelClub = new TravelClub(this.name, this.intro);
        travelClub.setId(this.id);
        travelClub.setFoundationTime(this.foundationTime);
        return travelClub;
    }
}
