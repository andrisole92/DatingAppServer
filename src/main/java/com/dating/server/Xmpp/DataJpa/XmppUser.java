package com.dating.server.Xmpp.DataJpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.PrecisionModel;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.IOException;
import java.sql.Date;

@Data
@Entity // This tells Hibernate to make a table out of this class
@Table(name = "users")
public class XmppUser {

    @Id
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "username")
    private java.lang.String username;

    @JsonIgnore
    private String password;
    @JsonIgnore
    private String serverkey = "";
    @JsonIgnore
    private String salt = "";
    @JsonIgnore
    private int iterationcount = 0;
    @JsonIgnore
    private Date created_at = new Date(System.currentTimeMillis());

    @Column(name = "geom", columnDefinition = "Point")
    @JsonSerialize(using = PointToJsonSerializer.class)
    @JsonDeserialize(using = JsonToPointDeserializer.class)
    private Point geom;
    private String full_name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username", nullable = true)
    private XmppLast xmppLast;

    @Transient
    @JsonIgnore
    private double distance;


}

class PointToJsonSerializer extends JsonSerializer<Point> {

    @Override
    public void serialize(Point value, JsonGenerator jgen,
                          SerializerProvider provider) throws IOException,
            JsonProcessingException {

        String jsonValue = "null";
        try {
            if (value != null) {
                double lat = value.getY();
                double lon = value.getX();
                jsonValue = String.format("POINT (%s %s)", lat, lon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        jgen.writeString(jsonValue);
    }

}

class JsonToPointDeserializer extends JsonDeserializer<Point> {

    private final static GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 3857);

    @Override
    public Point deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {

        try {
            String text = jp.getText();
            if (text == null || text.length() <= 0)
                return null;

            String[] coordinates = text.replaceFirst("POINT ?\\(", "").replaceFirst("\\)", "").split(" ");
            double lat = Double.parseDouble(coordinates[0]);
            double lon = Double.parseDouble(coordinates[1]);

            Point point = geometryFactory.createPoint(new Coordinate(lat, lon));
            return point;
        } catch (Exception e) {
            return null;
        }
    }

}