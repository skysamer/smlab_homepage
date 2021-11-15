package kr.lab.smartmobility.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_smlab_board")
@Data
@Getter
@Setter
@ToString
public class BoardVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bno;

    private int id;
    private String type;
    private String title;
    private String writer;
    private String body;

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy.MM.dd", timezone="Asia/Seoul")
    private Date date=new Date();

}
