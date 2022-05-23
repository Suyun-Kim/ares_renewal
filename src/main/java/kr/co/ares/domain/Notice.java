package kr.co.ares.domain;

import lombok.*;
import org.w3c.dom.Text;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_Notice")
@Entity
public class Notice {

    @Id
    @Column(name = "Idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idx;

    @Column(name = "Title")
    private String title;

    @Column(name = "Content")
    private String content;

    @Column(name = "Writer")
    private Integer writer;

    @Column(name = "CreateDate")
    private Timestamp createDate;

}
