package com.example.rubenvel.ligaaguila.util;

import com.example.rubenvel.ligaaguila.models.Noticia;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rubev on 20/05/2017.
 */

public class Data {

    private static List<Noticia>data;

    public static List<Noticia> getData(){
        if(data == null){
            data = new ArrayList<>();
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            Noticia n1 = new Noticia();
            n1.setNombre("DIM, por una victoria frente a Alianza para ratificarse como segundo");
            n1.setFecha("Actualizado Hace 2 Horas");
            n1.setDescripcion("");
            n1.setDesc("Luis Zubeldía dispondrá de una nómina mixta, con Didier Moreno y Christian Marrugo como titulares.");
            n1.setImagen("http://www.futbolred.com/contenido/liga-aguila/IMAGEN/IMAGEN-16852751-1.jpg");
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            Noticia n2 = new Noticia();
            n2.setNombre("'Mi idea es poner a pensar al técnico en la Copa y en la Liga': Mena");
            n2.setFecha("Actualizado Hace 3 Horas");
            n2.setDescripcion("");
            n2.setDesc("El delantero del América celebró su regreso al gol y habló de los compromisos de los 'diablos rojos'");
            n2.setImagen("http://m.futbolred.com/contenido/liga-aguila/IMAGEN/IMAGEN-16852768-1.jpg");
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            Noticia n3 = new Noticia();
            n3.setNombre("Huila buscará cerrar en casa con una victoria: recibe al Cortuluá");
            n3.setFecha("Actualizado Hace 3 Horas");
            n3.setDescripcion("");
            n3.setDesc("El equipo 'opita' ha cedido 14 puntos en el Guillermo Plazas Alcid, que lo ubican en la parte baja.");
            n3.setImagen("http://www.futbolred.com/contenido/liga-aguila/IMAGEN/IMAGEN-16852752-1.jpg");
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            Noticia n4 = new Noticia();
            n4.setNombre("Con la necesidad de un nuevo triunfo, Once Caldas recibirá al Pasto");
            n4.setFecha("Actualizado Hace 3 Horas");
            n4.setDescripcion("");
            n4.setDesc("Jugarán este sábado 20 de mayo a las 5:30 p.m., en el estadio Palogrande de Manizales.");
            n4.setImagen("http://www.futbolred.com/contenido/liga-aguila/IMAGEN/IMAGEN-16852754-1.jpg");
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            Noticia n5 = new Noticia();
            n5.setNombre("'Patriotas es un equipo parejo y bien competitivo': Miguel A. Russo");
            n5.setFecha("Actualizado Hace 14 Horas");
            n5.setDescripcion("");
            n5.setDesc("El técnico de Millonarios habló de los errores que debe corregir para confirmar la clasificación.");
            n5.setImagen("http://www.futbolred.com/contenido/liga-aguila/IMAGEN/IMAGEN-16852550-1.jpg");
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            Noticia n6 = new Noticia();
            n6.setNombre("'Queremos quitarle el invicto a Nacional en su casa': Máyer Candelo");
            n6.setFecha("Actualizado Hace 15 Horas");
            n6.setDescripcion("");
            n6.setDesc("El creativo 'azucarero' se mostró tranquilo por su futuro y positivo con su regreso al once titular.");
            n6.setImagen("http://www.futbolred.com/contenido/liga-aguila/IMAGEN/IMAGEN-16852551-1.jpg");
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            Noticia n7 = new Noticia();
            n7.setNombre("'Tenemos dos partidos para revertir la situación': Leandro Castellanos");
            n7.setFecha("Actualizado Hace 15 Horas");
            n7.setDescripcion("");
            n7.setDesc("El arquero de Santa Fe se ilusiona con clasificar en la Copa Libertadores y la Liga I-2017.");
            n7.setImagen("http://www.futbolred.com/contenido/liga-aguila/IMAGEN/IMAGEN-16852595-1.jpg");
            ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            Noticia n8 = new Noticia();
            n8.setNombre("'En el último tramo a veces nos aceleramos': David Mackalister Silva");
            n8.setFecha("Actualizado Hace 1 día");
            n8.setDescripcion("");
            n8.setDesc("De regreso a la titular de Millonarios, el volante habla de mejorar para asegurar la clasificación.");
            n8.setImagen("http://www.futbolred.com/contenido/liga-aguila/IMAGEN/IMAGEN-16852462-1.jpg");

            data.add(n1);
            data.add(n2);
            data.add(n3);
            data.add(n4);
            data.add(n5);
            data.add(n6);
            data.add(n7);
            data.add(n8);

        }
        return data;
    }
}
