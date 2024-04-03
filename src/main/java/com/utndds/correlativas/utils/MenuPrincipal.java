package com.utndds.correlativas.utils;

import com.utndds.correlativas.modelos.Alumno;
import com.utndds.correlativas.modelos.Inscripcion;
import com.utndds.correlativas.modelos.Materia;
import com.utndds.correlativas.persistencia.AlumnoRepository;
import com.utndds.correlativas.persistencia.InscripcionRepository;
import com.utndds.correlativas.persistencia.MateriaRepository;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class MenuPrincipal {


    public static void menu(AlumnoRepository alumnoRepository, InscripcionRepository inscripcionRepository, MateriaRepository materiaRepository){

        int opcion1, repeticiones, flag = 0;
        String palabra;
        Scanner lectura1 = new Scanner(System.in);
        Alumno alumno1;
        Materia materia1;
        Set<Materia> materias1 = new HashSet<>();   //no puede repetirse las materias
        Set<Alumno> alumnos1 = new HashSet<>();
        Set<Inscripcion> inscripciones1 = new HashSet<>();
        Long legajo = 0l;



        do{



            System.out.println("Menu principal");
            System.out.println("1. Ingresar una inscripción.");
            System.out.println("2. Ver los alumnos. ");
            System.out.println("3. Ver las materias. ");
            System.out.println("4. Ver las inscripciones. ");
            System.out.println("5. Salir. ");
            opcion1 = lectura1.nextInt();
            switch (opcion1){

                case 1:

                    System.out.println("Ingresar el legajo del alumno.");
                    legajo = lectura1.nextLong();
                    System.out.println("Ingresar la cantidad de materias.");
                    repeticiones = lectura1.nextInt();

                    Long finalLegajo = legajo;
                    alumno1 = alumnoRepository.findAll().stream().filter(alumno -> alumno.getLegajo() == finalLegajo).findFirst().orElse(null);

                    for(;repeticiones > 0;repeticiones --){

                        System.out.println("Ingresar el nombre de la materia. Cambiar los espacios por barra baja(_)");
                        palabra = lectura1.next();

                        String finalPalabra = palabra;
                        materia1 = materiaRepository.findAll().stream().filter(materia -> Objects.equals(materia.getNombre(), finalPalabra)).findFirst().orElse(null);

                        if(materia1 != null){
                            materias1.add(materia1);
                        }else{
                            System.out.println("Materia no encontrada.");
                            repeticiones++;
                        }

                    }

                    System.out.println(materias1);

                    if(alumno1 != null && !materias1.isEmpty()){
                        Inscripcion inscripcion1 = new Inscripcion(alumno1,materias1.stream().toList());

                        if(inscripcion1.aprobada()){

                            inscripcionRepository.save(inscripcion1);
                            alumnoRepository.save(alumno1);

                            System.out.println("Inscripción realizada y guardada.");
                        }else{
                            assert alumno1 != null;
                            alumno1.inscribir(materias1.stream().toList());
                        }
                    }else{
                        System.out.println("Materia o alumno nulo. ");
                    }

                    break;
                case 2:

                    System.out.println("Alumnos. ");
                    alumnos1 = new HashSet<>(alumnoRepository.findAll());

                    for(Alumno alumno:alumnos1){
                        System.out.println("alumno = " + alumno);
                    }

                    break;
                case 3:

                    System.out.println("Materias. ");
                    materias1 = new HashSet<>(materiaRepository.findAll());

                    for(Materia materia: materias1){
                        System.out.println("materia = " + materia);
                    }

                    break;
                case 4:

                    System.out.println("Inscripciones. ");
                    inscripciones1 = new HashSet<>(inscripcionRepository.findAll());

                    for(Inscripcion inscripcion: inscripciones1){

                        System.out.println("inscripcion = " + inscripcion);
                    }

                    break;
                default:
                    flag ++;
            }
        }while(flag == 0);


    }

}
