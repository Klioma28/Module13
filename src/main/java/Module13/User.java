package Module13;

public class User {
    private int id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;

    public User(int id, String name, String username, String email, Address address, String phone, String website, Company company) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public class Address{
        private String street;
        private String suite;
        private String city;
        private String zipcode;
        private Geo geo;

        public Address(String street, String suite, String city, String zipcode, Geo geo) {
            this.street = street;
            this.suite = suite;
            this.city = city;
            this.zipcode = zipcode;
            this.geo = geo;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getSuite() {
            return suite;
        }

        public void setSuite(String suite) {
            this.suite = suite;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getZipcode() {
            return zipcode;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }

        public Geo getGeo() {
            return geo;
        }

        public void setGeo(Geo geo) {
            this.geo = geo;
        }

        public class Geo{
            private double lat;
            private double lng;

            public Geo(double lat, double lng) {
                this.lat = lat;
                this.lng = lng;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            @Override
            public String toString() {
                return "{\n" +
                        "        \"lat\": \"" + lat + "\",\n" +
                        "        \"lng\": \"" + lng + "\"\n" +
                        "      }\n";
            }
        }

        @Override
        public String toString() {
            return "{\n" +
                    "      \"street\": \"" + street + "\",\n" +
                    "      \"suite\": \"" + suite + "\",\n" +
                    "      \"city\": \"" + city + "\",\n" +
                    "      \"zipcode\": \"" + zipcode + "\",\n" +
                    "      \"geo\": " + geo +
                    "    }";
        }
    }

    public class Company{
        private String name;
        private String catchPhrase;
        private String bs;

        public Company(String name, String catchPhrase, String bs) {
            this.name = name;
            this.catchPhrase = catchPhrase;
            this.bs = bs;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCatchPhrase() {
            return catchPhrase;
        }

        public void setCatchPhrase(String catchPhrase) {
            this.catchPhrase = catchPhrase;
        }

        public String getBs() {
            return bs;
        }

        public void setBs(String bs) {
            this.bs = bs;
        }

        @Override
        public String toString() {
            return "{\n" +
                    "      \"name\": \"" + name + "\",\n" +
                    "      \"catchPhrase\": \"" + catchPhrase + "\",\n" +
                    "      \"bs\": \"" + bs + "\"\n" +
                    "    }";
        }
    }

    @Override
    public String toString() {
        return "\n  {\n" +
                "    \"id\": \"" + id + "\",\n" +
                "    \"name\": \"" + name + "\",\n" +
                "    \"username\": \"" + username + "\",\n" +
                "    \"email\": \"" + email + "\",\n" +
                "    \"address\": " + address + ",\n" +
                "    \"phone\": \"" + phone + "\",\n" +
                "    \"website\": \"" + website + "\",\n" +
                "    \"company\": " + company + "\n" +
                "  }";
    }
}
