import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

class XMLParser{
        public static void parseFromFile(String path, HashMap<Integer, Planet> hashMap){
            try {

                File file = new File(path);
                if(!file.exists()){
                    System.out.println("Файл не существует");
                    System.exit(0);
                }
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(file);

                NodeList nList = doc.getElementsByTagName("planet");

                for (int i = 0; i < nList.getLength(); i++) {
                    double density;
                    String shape;
                    String name;
                    int Radious;


                    Node nNode = nList.item(i);

                    System.out.println();

                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                        Element eElement = (Element) nNode;

                        Radious = Integer.parseInt(eElement
                                .getAttribute("Radious"));
                        density = Double.parseDouble(eElement
                                .getElementsByTagName("density")
                                .item(0)
                                .getTextContent());

                        shape=eElement
                                .getElementsByTagName("shape")
                                .item(0)
                                .getTextContent();
                        name=eElement
                                .getElementsByTagName("name")
                                .item(0)
                                .getTextContent();
                        Planet planet = new Planet(density, shape, name);

                        hashMap.put(Radious, planet);
                        System.out.println("Плотность: "+density+" форма: "+shape+" name: "+name);
                    }
                }
                System.out.println("\nЗагрузилось "+hashMap.size()+" объектов");

            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            }
        }

        public static void parseToFile(String path, HashMap<Integer, Planet> hashMap){
            try {
                try {
                    XMLOutputFactory output = XMLOutputFactory.newInstance();
                    XMLStreamWriter writer = output.createXMLStreamWriter(new FileWriter(path));
                    writer.writeStartDocument();
                    writer.writeStartElement("planets");
                    Iterator it = hashMap.entrySet().iterator();
                    while (it.hasNext()) {
                        HashMap.Entry<Integer, Planet> pair = (HashMap.Entry<Integer, Planet>) it.next();
                        Planet planet = pair.getValue();
                        Integer Radious = pair.getKey();


                        System.out.println("Radious: "+Radious.toString()+" плотность: "+planet.Density+" форма: "+planet.shape+" name: "+planet.name);

                        writer.writeStartElement("planet");
                        writer.writeAttribute("Radious", Radious.toString());

                        writer.writeStartElement("density");
                        writer.writeCharacters(""+ planet.Density);
                        writer.writeEndElement();

                        writer.writeStartElement("shape");
                        writer.writeCharacters(planet.shape);
                        writer.writeEndElement();

                        writer.writeStartElement("name");
                        writer.writeCharacters(planet.name);
                        writer.writeEndElement();

                        writer.writeEndElement();
                    }
                    writer.writeEndElement();
                    writer.writeEndDocument();
                    writer.flush();



                } catch (XMLStreamException e) {
                    e.printStackTrace();
                }
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }

