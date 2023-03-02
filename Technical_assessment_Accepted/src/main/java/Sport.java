public enum Sport {
    Football(1), Basketball(2);

    private final int id;

    private Sport(final int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Sport getEnumValue(final int id) {
        for (final Sport type : Sport.values()) {
            if (type.getId() == id) {
                return type;
            }
        }
        return null;
    }
}
