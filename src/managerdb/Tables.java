package managerdb;

public class Tables {

    // SQL statement for creating a new table
    protected String tAgencias = "CREATE TABLE IF NOT EXISTS agencies (\n"
            + "	agency_id integer PRIMARY KEY,\n"
            + "	name text NOT NULL,\n"
            + "	cnpj text NOT NULL UNIQUE,\n"
            + "	contact_id integer NOT NULL REFERENCES contacts(contact_id),\n"
            + " address_id integer NOT NULL REFERENCES addresses(address_id)\n"
            + ");";

    protected String tUsuarios = "CREATE TABLE IF NOT EXISTS users (\n"
            + "	user_id integer PRIMARY KEY,\n"
            + "	name text NOT NULL,\n"
            + " contact_id integer NOT NULL REFERENCES contacts(contact_id),\n"
            + " package_id integer NOT NULL REFERENCES packages(package_id)\n"
            + ");";

    protected String tContatos = "CREATE TABLE IF NOT EXISTS contacts (\n"
            + "	contact_id integer PRIMARY KEY,\n"
            + "	phone text NOT NULL UNIQUE,\n"
            + "	email text NOT NULL UNIQUE\n"
            + ");";

    protected String tEnderecos = "CREATE TABLE IF NOT EXISTS addresses (\n"
            + "	address_id integer PRIMARY KEY,\n"
            + "	street text NOT NULL,\n"
            + "	neighborhood text NOT NULL,\n"
            + "	cep text NOT NULL,\n"
            + "	number integer NOT NULL,\n"
            + " city_id integer NOT NULL  REFERENCES cities(city_id)\n"
            + ");";

    protected String tCidades = "CREATE TABLE IF NOT EXISTS cities (\n"
            + "	city_id integer PRIMARY KEY,\n"
            + "	name text NOT NULL,\n"
            + "	state text NOT NULL,\n"
            + "	country  text NOT NULL\n"
            + ");";

    protected String tPacotes = "CREATE TABLE IF NOT EXISTS packages (\n"
            + "	package_id integer PRIMARY KEY,\n"
            + "	name text NOT NULL,\n"
            + "	data_start text,\n"
            + "	data_end text,\n"
            + "	value double NOT NULL,\n"
            + " agency_id integer NOT NULL REFERENCES agencies(agency_id)\n"
            + ");";

    protected String tAtracoes = "CREATE TABLE IF NOT EXISTS events (\n"
            + "	event_id integer PRIMARY KEY,\n"
            + "	name text NOT NULL,\n"
            + "	day text NOT NULL,\n"
            + "	hour text NOT NULL,\n"
            + "	history text,\n"
            + "	min_age integer,\n"
            + "	bands text,\n"
            + "	danger text,\n"
            + "	middle_values text,\n"
            + " address_id integer NOT NULL REFERENCES addresses(address_id)\n"
            + ");";


    protected String tPacotesCidades = "CREATE TABLE IF NOT EXISTS packs_cities (\n"
            + "	id integer PRIMARY KEY,\n"
            + "	package_id integer NOT NULL REFERENCES packages(package_id),\n"
            + "	city_id integer NOT NULL  REFERENCES cities(city_id)\n"
            + ");";

    protected String tPacotesAtracoes = "CREATE TABLE IF NOT EXISTS packs_events (\n"
            + "	id integer PRIMARY KEY,\n"
            + "	package_id integer NOT NULL REFERENCES packages(package_id),\n"
            + "	event_id integer NOT NULL  REFERENCES events(event_id)\n"
            + ");";
}
