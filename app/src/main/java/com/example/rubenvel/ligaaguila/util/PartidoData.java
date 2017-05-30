package com.example.rubenvel.ligaaguila.util;

import com.example.rubenvel.ligaaguila.models.Partido;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rubev on 30/05/2017.
 */

public class PartidoData {

    private static List<Partido> dataP;

    public static List<Partido> getDataPartido(){
        if(dataP == null){
            dataP = new ArrayList<>();
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            Partido p1 = new Partido();
            p1.setEquipo1("Cortuluá");
            p1.setEquipo2("Once Caldas");
            p1.setFecha("Lunes 29 Mayo");
            p1.setDescripcion("");
            p1.setDesc("Luis Zubeldía dispondrá de una nómina mixta, con Didier Moreno y Christian Marrugo como titulares.");
            p1.setImagen("http://www.sitioco.com/futbolcolombiano/wp-content/uploads/2015/10/ver-cortulua-vs-once-caldas-sabado-31-de-octubre-de-2015.jpg");
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            Partido p2 = new Partido();
            p2.setEquipo1("América de Cali");
            p2.setEquipo2("Deportivo Pasto");
            p2.setFecha("Miércoles 31 Mayo");
            p2.setDescripcion("");
            p2.setDesc("Luis Zubeldía dispondrá de una nómina mixta, con Didier Moreno y Christian Marrugo como titulares.");
            p2.setImagen("http://www.sitioco.com/futbolcolombiano/wp-content/uploads/2017/02/ver-america-vs-pasto-domingo-26-de-febrero-de-2017.jpg");
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            Partido p3 = new Partido();
            p3.setEquipo1("Atl. Bucaramanga");
            p3.setEquipo2("Millonarios");
            p3.setFecha("Miércoles 31 Mayo");
            p3.setDescripcion("");
            p3.setDesc("Luis Zubeldía dispondrá de una nómina mixta, con Didier Moreno y Christian Marrugo como titulares.");
            p3.setImagen("http://www.sitioco.com/futbolcolombiano/wp-content/uploads/2016/04/ver-bucaramanga-vs-millonarios-sabado-23-de-abril-de-2016.jpg");
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            Partido p4 = new Partido();
            p4.setEquipo1("Dep. Cali");
            p4.setEquipo2("Ind. Medellín");
            p4.setFecha("Miércoles 31 Mayo");
            p4.setDescripcion("");
            p4.setDesc("Luis Zubeldía dispondrá de una nómina mixta, con Didier Moreno y Christian Marrugo como titulares.");
            p4.setImagen("http://www.sitioco.com/futbolcolombiano/wp-content/uploads/2014/09/ver-cali-vs-medellin-domingo-28-de-septiembre-de-2014.jpg");
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            Partido p5 = new Partido();
            p5.setEquipo1("Jaguares de Córdoba");
            p5.setEquipo2("Atl. Nacional");
            p5.setFecha("Miércoles 31 Mayo");
            p5.setDescripcion("");
            p5.setDesc("Luis Zubeldía dispondrá de una nómina mixta, con Didier Moreno y Christian Marrugo como titulares.");
            p5.setImagen("http://www.sitioco.com/futbolcolombiano/wp-content/uploads/2015/04/ver-jaguares-vs-nacional-domingo-12-de-abril-de-2015.jpg");
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            Partido p6 = new Partido();
            p6.setEquipo1("Atl. Nacional");
            p6.setEquipo2("Jaguares de Córdoba");
            p6.setFecha("Domingo 4 Junio");
            p6.setDescripcion("");
            p6.setDesc("Luis Zubeldía dispondrá de una nómina mixta, con Didier Moreno y Christian Marrugo como titulares.");
            p6.setImagen("http://www.sitioco.com/futbolcolombiano/wp-content/uploads/2015/10/ver-nacional-vs-jaguares-sabado-3-de-octubre-de-2015.jpg");
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            Partido p7 = new Partido();
            p7.setEquipo1("Dep. Pasto");
            p7.setEquipo2("América de Cali");
            p7.setFecha("Domingo 4 Junio");
            p7.setDescripcion("");
            p7.setDesc("Luis Zubeldía dispondrá de una nómina mixta, con Didier Moreno y Christian Marrugo como titulares.");
            p7.setImagen("http://www.sitioco.com/futbolcolombiano/wp-content/uploads/2017/02/ver-america-vs-pasto-domingo-26-de-febrero-de-2017.jpg");

            dataP.add(p1);
            dataP.add(p2);
            dataP.add(p3);
            dataP.add(p4);
            dataP.add(p5);
            dataP.add(p6);
            dataP.add(p7);

        }

        return dataP;
    }
}
