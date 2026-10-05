import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.*;
import java.util.stream.Collectors;

public class Main extends Application {

    // ============================================================
    // MOUNTAIN MODEL
    // ============================================================

    static class Mountain {

        int id;
        String name;
        double height;
        String country;
        String location;
        double latitude;
        double longitude;
        String description;
        String image;
        String firstAscent;
        String facts;

        Mountain(
                int id,
                String name,
                double height,
                String country,
                String location,
                double latitude,
                double longitude,
                String description,
                String image,
                String firstAscent,
                String facts
        ) {
            this.id = id;
            this.name = name;
            this.height = height;
            this.country = country;
            this.location = location;
            this.latitude = latitude;
            this.longitude = longitude;
            this.description = description;
            this.image = image;
            this.firstAscent = firstAscent;
            this.facts = facts;
        }
    }

    // ============================================================
    // APPLICATION VARIABLES
    // ============================================================

    private Stage stage;
    private BorderPane mainLayout;

    private final List<Mountain> mountains =
            new ArrayList<>();

    private final String BG =
            "linear-gradient(to bottom right, #061923, #0b2c3a, #123e4a)";

    // ============================================================
    // START APPLICATION
    // ============================================================

    @Override
    public void start(Stage primaryStage) {

        stage = primaryStage;

        stage.setTitle("Himalayan Explorer");
        stage.setMinWidth(1100);
        stage.setMinHeight(700);

        loadMountainData();

        showDashboard();

        stage.show();
    }

    // ============================================================
    // MAIN
    // ============================================================

    public static void main(String[] args) {
        launch(args);
    }

    // ============================================================
    // MOUNTAIN DATA
    // ============================================================

    private void loadMountainData() {

        mountains.add(new Mountain(
                1,
                "Mount Everest",
                8848.86,
                "Nepal / China",
                "Mahalangur Himal",
                27.9881,
                86.9250,
                "Mount Everest is the highest mountain above sea level and one of the most famous peaks in the world.",
                "https://images.unsplash.com/photo-1544735716-392fe2489ffa?auto=format&fit=crop&w=1000&q=80",
                "1953 - Edmund Hillary and Tenzing Norgay",
                "It is the highest point on Earth above sea level."
        ));

        mountains.add(new Mountain(
                2,
                "K2",
                8611,
                "Pakistan / China",
                "Karakoram",
                35.8808,
                76.5158,
                "K2 is the second-highest mountain in the world and is located in the Karakoram range.",
                "https://images.unsplash.com/photo-1520637836862-4d197d17c52a?auto=format&fit=crop&w=1000&q=80",
                "1954 - Lino Lacedelli and Achille Compagnoni",
                "K2 is known as one of the most technically difficult major mountains."
        ));

        mountains.add(new Mountain(
                3,
                "Kangchenjunga",
                8586,
                "Nepal / India",
                "Kangchenjunga Himal",
                27.7025,
                88.1475,
                "Kangchenjunga is the third-highest mountain in the world.",
                "https://images.unsplash.com/photo-1464822759023-fed622ff2c3b?auto=format&fit=crop&w=1000&q=80",
                "1955 - Joe Brown and George Band",
                "The mountain has five major peaks."
        ));

        mountains.add(new Mountain(
                4,
                "Lhotse",
                8516,
                "Nepal / China",
                "Mahalangur Himal",
                27.9617,
                86.9330,
                "Lhotse is connected to Mount Everest through the South Col.",
                "https://images.unsplash.com/photo-1528181304800-259b08848526?auto=format&fit=crop&w=1000&q=80",
                "1956 - Ernst Reiss and Fritz Luchsinger",
                "Lhotse means South Peak in Tibetan."
        ));

        mountains.add(new Mountain(
                5,
                "Makalu",
                8485,
                "Nepal / China",
                "Mahalangur Himal",
                27.8897,
                87.0888,
                "Makalu is an isolated pyramid-shaped mountain located southeast of Everest.",
                "https://images.unsplash.com/photo-1519681393784-d120267933ba?auto=format&fit=crop&w=1000&q=80",
                "1955 - French expedition",
                "Its distinctive shape makes it one of the most recognizable Himalayan peaks."
        ));

        mountains.add(new Mountain(
                6,
                "Cho Oyu",
                8188,
                "Nepal / China",
                "Mahalangur Himal",
                28.0942,
                86.6608,
                "Cho Oyu is the sixth-highest mountain in the world.",
                "https://images.unsplash.com/photo-1486911278844-a81c5267e227?auto=format&fit=crop&w=1000&q=80",
                "1954 - Herbert Tichy, Joseph Jochler and Pasang Dawa Lama",
                "It is often considered one of the more accessible eight-thousanders."
        ));

        mountains.add(new Mountain(
                7,
                "Dhaulagiri I",
                8167,
                "Nepal",
                "Dhaulagiri Himal",
                28.6967,
                83.4875,
                "Dhaulagiri I is the highest mountain in the Dhaulagiri range.",
                "https://images.unsplash.com/photo-1470770841072-f978cf4d019e?auto=format&fit=crop&w=1000&q=80",
                "1960 - Swiss-Austrian-Nepali expedition",
                "Its name means White Mountain."
        ));

        mountains.add(new Mountain(
                8,
                "Manaslu",
                8163,
                "Nepal",
                "Mansiri Himal",
                28.5497,
                84.5617,
                "Manaslu is the eighth-highest mountain in the world.",
                "https://images.unsplash.com/photo-1464278533981-50106e6176b1?auto=format&fit=crop&w=1000&q=80",
                "1956 - Toshio Imanishi and Gyalzen Norbu",
                "Manaslu means Mountain of the Spirit."
        ));

        mountains.add(new Mountain(
                9,
                "Nanga Parbat",
                8126,
                "Pakistan",
                "Western Himalayas",
                35.2372,
                74.5892,
                "Nanga Parbat is one of the major peaks of the western Himalayas.",
                "https://images.unsplash.com/photo-1464278533981-50106e6176b1?auto=format&fit=crop&w=1000&q=80",
                "1953 - Hermann Buhl",
                "It is also called the Killer Mountain because of its difficult climbing history."
        ));

        mountains.add(new Mountain(
                10,
                "Annapurna I",
                8091,
                "Nepal",
                "Annapurna Himal",
                28.5958,
                83.8203,
                "Annapurna I was the first eight-thousand-meter mountain successfully climbed.",
                "https://images.unsplash.com/photo-1500534623283-312aade485b7?auto=format&fit=crop&w=1000&q=80",
                "1950 - Maurice Herzog and Louis Lachenal",
                "Annapurna I was the first 8000-meter peak climbed by humans."
        ));
    }

    // ============================================================
    // DASHBOARD
    // ============================================================

    private void showDashboard() {

        BorderPane root = new BorderPane();

        root.setStyle(
                "-fx-background-color:" + BG + ";"
        );

        root.setTop(createNavigation());

        VBox hero = new VBox(22);

        hero.setAlignment(Pos.CENTER);

        Label smallTitle =
                new Label("DISCOVER THE ROOF OF THE WORLD");

        smallTitle.setStyle(
                "-fx-text-fill:#8be9fd;" +
                "-fx-font-size:14px;" +
                "-fx-font-weight:bold;"
        );

        Label title =
                new Label("Himalayan Explorer");

        title.setStyle(
                "-fx-text-fill:white;" +
                "-fx-font-size:58px;" +
                "-fx-font-weight:bold;"
        );

        Label subtitle =
                new Label(
                        "Explore the world's greatest mountain range"
                );

        subtitle.setStyle(
                "-fx-text-fill:#d7f6ff;" +
                "-fx-font-size:22px;"
        );

        Label description =
                new Label(
                        "Discover legendary peaks, mountain heights, " +
                        "locations and fascinating facts."
                );

        description.setStyle(
                "-fx-text-fill:#b9ced6;" +
                "-fx-font-size:16px;"
        );

        Button explore =
                createButton(
                        "Explore Mountains",
                        true
                );

        explore.setOnAction(
                e -> showMountains()
        );

        Button map =
                createButton(
                        "Explore Map",
                        false
                );

        map.setOnAction(
                e -> showMap()
        );

        HBox buttons =
                new HBox(15, explore, map);

        buttons.setAlignment(Pos.CENTER);

        hero.getChildren().addAll(
                smallTitle,
                title,
                subtitle,
                description,
                buttons
        );

        root.setCenter(hero);

        root.setBottom(createFeatureBar());

        setScene(root);
    }

    // ============================================================
    // NAVIGATION
    // ============================================================

    private HBox createNavigation() {

        HBox nav = new HBox(20);

        nav.setAlignment(Pos.CENTER_LEFT);

        nav.setPadding(
                new Insets(18, 30, 18, 30)
        );

        nav.setStyle(
                "-fx-background-color:rgba(2,15,23,0.85);"
        );

        Label logo =
                new Label("🏔");

        logo.setStyle(
                "-fx-font-size:30px;"
        );

        Label name =
                new Label("HIMALAYAN EXPLORER");

        name.setStyle(
                "-fx-text-fill:white;" +
                "-fx-font-size:19px;" +
                "-fx-font-weight:bold;"
        );

        Region spacer = new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        Button home =
                navButton("Home");

        Button mountains =
                navButton("Explore");

        Button map =
                navButton("Map");

        Button gallery =
                navButton("Gallery");

        Button stats =
                navButton("Statistics");

        Button about =
                navButton("About");

        home.setOnAction(
                e -> showDashboard()
        );

        mountains.setOnAction(
                e -> showMountains()
        );

        map.setOnAction(
                e -> showMap()
        );

        gallery.setOnAction(
                e -> showGallery()
        );

        stats.setOnAction(
                e -> showStatistics()
        );

        about.setOnAction(
                e -> showAbout()
        );

        nav.getChildren().addAll(
                logo,
                name,
                spacer,
                home,
                mountains,
                map,
                gallery,
                stats,
                about
        );

        return nav;
    }

    // ============================================================
    // FEATURE BAR
    // ============================================================

    private HBox createFeatureBar() {

        HBox bar =
                new HBox(80);

        bar.setAlignment(Pos.CENTER);

        bar.setPadding(
                new Insets(20)
        );

        bar.setStyle(
                "-fx-background-color:rgba(2,15,23,0.7);"
        );

        bar.getChildren().addAll(
                feature("10", "Major Peaks"),
                feature("8848.86 m", "Highest Peak"),
                feature("5+", "Countries"),
                feature("∞", "Stories")
        );

        return bar;
    }

    private VBox feature(
            String number,
            String text
    ) {

        VBox box =
                new VBox(5);

        box.setAlignment(Pos.CENTER);

        Label numberLabel =
                new Label(number);

        numberLabel.setStyle(
                "-fx-text-fill:#8be9fd;" +
                "-fx-font-size:23px;" +
                "-fx-font-weight:bold;"
        );

        Label textLabel =
                new Label(text);

        textLabel.setStyle(
                "-fx-text-fill:#a9bec7;" +
                "-fx-font-size:13px;"
        );

        box.getChildren().addAll(
                numberLabel,
                textLabel
        );

        return box;
    }

    // ============================================================
    // EXPLORE MOUNTAINS
    // ============================================================

    private void showMountains() {

        BorderPane root =
                new BorderPane();

        root.setStyle(
                "-fx-background-color:" + BG + ";"
        );

        VBox header =
                new VBox(15);

        header.setPadding(
                new Insets(25)
        );

        HBox top =
                new HBox(15);

        top.setAlignment(
                Pos.CENTER_LEFT
        );

        Button back =
                smallButton("← Home");

        back.setOnAction(
                e -> showDashboard()
        );

        Label title =
                pageTitle(
                        "Explore Himalayan Peaks"
                );

        Region spacer =
                new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        Button low =
                smallButton("Height ↑");

        Button high =
                smallButton("Height ↓");

        TextField search =
                new TextField();

        search.setPromptText(
                "Search mountain, country or location..."
        );

        search.setPrefHeight(42);

        search.setStyle(
                "-fx-background-color:#102d39;" +
                "-fx-text-fill:white;" +
                "-fx-prompt-text-fill:#78929d;" +
                "-fx-background-radius:10;"
        );

        FlowPane grid =
                new FlowPane();

        grid.setHgap(20);
        grid.setVgap(20);
        grid.setPadding(
                new Insets(20)
        );

        grid.setAlignment(
                Pos.TOP_CENTER
        );

        ScrollPane scroll =
                new ScrollPane(grid);

        scroll.setFitToWidth(true);

        scroll.setStyle(
                "-fx-background:#071923;" +
                "-fx-background-color:#071923;"
        );

        Runnable refresh =
                () -> {

                    String text =
                            search.getText()
                                    .toLowerCase()
                                    .trim();

                    List<Mountain> result =
                            mountains.stream()
                                    .filter(m ->
                                            text.isEmpty()
                                                    || m.name.toLowerCase()
                                                    .contains(text)
                                                    || m.country.toLowerCase()
                                                    .contains(text)
                                                    || m.location.toLowerCase()
                                                    .contains(text))
                                    .collect(Collectors.toList());

                    displayCards(grid, result);
                };

        search.textProperty()
                .addListener(
                        (obs, oldValue, newValue) ->
                                refresh.run()
                );

        low.setOnAction(
                e -> {
                    mountains.sort(
                            Comparator.comparingDouble(
                                    m -> m.height
                            )
                    );
                    refresh.run();
                }
        );

        high.setOnAction(
                e -> {
                    mountains.sort(
                            Comparator.comparingDouble(
                                    (Mountain m) ->
                                            m.height
                            ).reversed()
                    );
                    refresh.run();
                }
        );

        top.getChildren().addAll(
                back,
                title,
                spacer,
                low,
                high
        );

        header.getChildren().addAll(
                top,
                search
        );

        root.setTop(header);
        root.setCenter(scroll);

        displayCards(
                grid,
                mountains
        );

        setScene(root);
    }

    // ============================================================
    // MOUNTAIN CARDS
    // ============================================================

    private void displayCards(
            FlowPane grid,
            List<Mountain> list
    ) {

        grid.getChildren().clear();

        if (list.isEmpty()) {

            Label empty =
                    new Label("No mountains found.");

            empty.setStyle(
                    "-fx-text-fill:#9db5be;" +
                    "-fx-font-size:20px;"
            );

            grid.getChildren().add(empty);

            return;
        }

        for (Mountain mountain : list) {

            VBox card =
                    createMountainCard(mountain);

            grid.getChildren().add(card);
        }
    }

    // ============================================================
    // MOUNTAIN CARD
    // ============================================================

    private VBox createMountainCard(
            Mountain mountain
    ) {

        VBox card =
                new VBox(10);

        card.setPrefWidth(330);

        card.setPadding(
                new Insets(12)
        );

        card.setStyle(
                "-fx-background-color:#102a36;" +
                "-fx-background-radius:18;" +
                "-fx-border-color:#1d4858;" +
                "-fx-border-radius:18;"
        );

        ImageView imageView =
                new ImageView();

        try {

            Image image =
                    new Image(
                            mountain.image,
                            305,
                            180,
                            false,
                            true,
                            true
                    );

            imageView.setImage(image);

        } catch (Exception ignored) {
        }

        imageView.setFitWidth(305);
        imageView.setFitHeight(180);

        Label name =
                new Label(mountain.name);

        name.setStyle(
                "-fx-text-fill:white;" +
                "-fx-font-size:20px;" +
                "-fx-font-weight:bold;"
        );

        Label height =
                new Label(
                        String.format(
                                "%,.2f meters",
                                mountain.height
                        )
                );

        height.setStyle(
                "-fx-text-fill:#8be9fd;" +
                "-fx-font-size:17px;" +
                "-fx-font-weight:bold;"
        );

        Label country =
                new Label(
                        "📍 " + mountain.country
                );

        country.setStyle(
                "-fx-text-fill:#a9c3cd;"
        );

        Label description =
                new Label(
                        mountain.description
                );

        description.setWrapText(true);

        description.setMaxHeight(65);

        description.setStyle(
                "-fx-text-fill:#b5cbd2;" +
                "-fx-font-size:13px;"
        );

        Button details =
                createButton(
                        "View Details →",
                        true
                );

        details.setOnAction(
                e -> showDetails(mountain)
        );

        card.getChildren().addAll(
                imageView,
                name,
                height,
                country,
                description,
                details
        );

        card.setOnMouseEntered(
                e -> card.setStyle(
                        "-fx-background-color:#143644;" +
                        "-fx-background-radius:18;" +
                        "-fx-border-color:#4fc9e5;" +
                        "-fx-border-radius:18;" +
                        "-fx-translate-y:-5;"
                )
        );

        card.setOnMouseExited(
                e -> card.setStyle(
                        "-fx-background-color:#102a36;" +
                        "-fx-background-radius:18;" +
                        "-fx-border-color:#1d4858;" +
                        "-fx-border-radius:18;"
                )
        );

        return card;
    }

    // ============================================================
    // MOUNTAIN DETAILS
    // ============================================================

    private void showDetails(
            Mountain mountain
    ) {

        Dialog<Void> dialog =
                new Dialog<>();

        dialog.setTitle(
                mountain.name
        );

        VBox content =
                new VBox(15);

        content.setPadding(
                new Insets(25)
        );

        content.setPrefWidth(650);

        ImageView imageView =
                new ImageView();

        try {

            Image image =
                    new Image(
                            mountain.image,
                            580,
                            280,
                            true,
                            true,
                            true
                    );

            imageView.setImage(image);

        } catch (Exception ignored) {
        }

        Label title =
                new Label(mountain.name);

        title.setStyle(
                "-fx-text-fill:#8be9fd;" +
                "-fx-font-size:28px;" +
                "-fx-font-weight:bold;"
        );

        Label information =
                new Label(
                        "Height: "
                                + String.format(
                                "%,.2f m",
                                mountain.height
                        )
                                + "\n\nCountry: "
                                + mountain.country
                                + "\n\nLocation: "
                                + mountain.location
                                + "\n\nCoordinates: "
                                + String.format(
                                "%.4f°, %.4f°",
                                mountain.latitude,
                                mountain.longitude
                        )
                                + "\n\nFirst Ascent: "
                                + mountain.firstAscent
                                + "\n\nInteresting Fact: "
                                + mountain.facts
                                + "\n\nDescription: "
                                + mountain.description
                );

        information.setWrapText(true);

        information.setStyle(
                "-fx-text-fill:#c3d5db;" +
                "-fx-font-size:14px;"
        );

        content.getChildren().addAll(
                imageView,
                title,
                information
        );

        dialog.getDialogPane()
                .setContent(content);

        dialog.getDialogPane()
                .getButtonTypes()
                .add(
                        new ButtonType(
                                "Close",
                                ButtonBar.ButtonData.CANCEL_CLOSE
                        )
                );

        dialog.showAndWait();
    }

    // ============================================================
    // INTERACTIVE MAP
    // ============================================================

    private void showMap() {

        BorderPane root =
                new BorderPane();

        root.setStyle(
                "-fx-background-color:" + BG + ";"
        );

        VBox header =
                new VBox(10);

        header.setPadding(
                new Insets(25)
        );

        Button back =
                smallButton("← Home");

        back.setOnAction(
                e -> showDashboard()
        );

        Label title =
                pageTitle(
                        "Interactive Himalayan Map"
                );

        Label subtitle =
                new Label(
                        "Click a marker to view mountain information."
                );

        subtitle.setStyle(
                "-fx-text-fill:#9fb8c2;"
        );

        header.getChildren().addAll(
                back,
                title,
                subtitle
        );

        root.setTop(header);

        StackPane map =
                new StackPane();

        map.setPrefSize(
                950,
                600
        );

        map.setStyle(
                "-fx-background-color:" +
                "linear-gradient(to bottom,#1d505a,#102e38);" +
                "-fx-background-radius:20;"
        );

        Label tibet =
                new Label(
                        "TIBETAN PLATEAU"
                );

        tibet.setStyle(
                "-fx-text-fill:rgba(255,255,255,0.25);" +
                "-fx-font-size:22px;" +
                "-fx-font-weight:bold;"
        );

        StackPane.setAlignment(
                tibet,
                Pos.TOP_CENTER
        );

        StackPane.setMargin(
                tibet,
                new Insets(50,0,0,0)
        );

        map.getChildren().add(tibet);

        Label india =
                new Label(
                        "INDIAN SUBCONTINENT"
                );

        india.setStyle(
                "-fx-text-fill:rgba(255,255,255,0.25);" +
                "-fx-font-size:20px;" +
                "-fx-font-weight:bold;"
        );

        StackPane.setAlignment(
                india,
                Pos.BOTTOM_CENTER
        );

        StackPane.setMargin(
                india,
                new Insets(0,0,40,0)
        );

        map.getChildren().add(india);

        for (Mountain mountain :
                mountains) {

            addMapMarker(
                    map,
                    mountain
            );
        }

        root.setCenter(map);

        setScene(root);
    }

    // ============================================================
    // MAP MARKER
    // ============================================================

    private void addMapMarker(
            StackPane map,
            Mountain mountain
    ) {

        Circle marker =
                new Circle(8);

        marker.setFill(
                Color.web("#8be9fd")
        );

        marker.setStroke(
                Color.WHITE
        );

        marker.setStrokeWidth(2);

        double x =
                ((mountain.longitude - 73)
                        / (90 - 73))
                        * 850 - 425;

        double y =
                260 -
                        ((mountain.latitude - 26)
                                / (37 - 26))
                                * 520;

        marker.setTranslateX(x);
        marker.setTranslateY(y);

        Tooltip tooltip =
                new Tooltip(
                        mountain.name
                                + "\n"
                                + String.format(
                                "%,.0f m",
                                mountain.height
                        )
                );

        Tooltip.install(
                marker,
                tooltip
        );

        marker.setOnMouseClicked(
                e -> showMapInformation(
                        mountain
                )
        );

        map.getChildren().add(marker);
    }

    // ============================================================
    // MAP INFORMATION
    // ============================================================

    private void showMapInformation(
            Mountain mountain
    ) {

        Alert alert =
                new Alert(
                        Alert.AlertType.INFORMATION
                );

        alert.setTitle(
                "Mountain Information"
        );

        alert.setHeaderText(
                mountain.name
        );

        alert.setContentText(
                "Height: "
                        + String.format(
                        "%,.2f meters",
                        mountain.height
                )
                        + "\n\nCountry: "
                        + mountain.country
                        + "\n\nLocation: "
                        + mountain.location
                        + "\n\nCoordinates: "
                        + String.format(
                        "%.4f°, %.4f°",
                        mountain.latitude,
                        mountain.longitude
                )
                        + "\n\n"
                        + mountain.description
        );

        alert.showAndWait();
    }

    // ============================================================
    // GALLERY
    // ============================================================

    private int galleryIndex = 0;

    private void showGallery() {

        BorderPane root =
                new BorderPane();

        root.setStyle(
                "-fx-background-color:" + BG + ";"
        );

        VBox header =
                new VBox(10);

        header.setPadding(
                new Insets(25)
        );

        Button back =
                smallButton("← Home");

        back.setOnAction(
                e -> showDashboard()
        );

        Label title =
                pageTitle("Mountain Gallery");

        header.getChildren().addAll(
                back,
                title
        );

        root.setTop(header);

        VBox gallery =
                new VBox(20);

        gallery.setAlignment(
                Pos.CENTER
        );

        gallery.setPadding(
                new Insets(20)
        );

        ImageView imageView =
                new ImageView();

        imageView.setFitWidth(800);
        imageView.setFitHeight(480);
        imageView.setPreserveRatio(true);

        Label name =
                new Label();

        name.setStyle(
                "-fx-text-fill:white;" +
                "-fx-font-size:30px;" +
                "-fx-font-weight:bold;"
        );

        Label description =
                new Label();

        description.setWrapText(true);
        description.setMaxWidth(750);

        description.setStyle(
                "-fx-text-fill:#b4cbd3;" +
                "-fx-font-size:15px;"
        );

        Label counter =
                new Label();

        counter.setStyle(
                "-fx-text-fill:#8be9fd;" +
                "-fx-font-size:15px;" +
                "-fx-font-weight:bold;"
        );

        Button previous =
                createButton(
                        "← Previous",
                        false
                );

        Button next =
                createButton(
                        "Next →",
                        true
                );

        HBox controls =
                new HBox(
                        20,
                        previous,
                        counter,
                        next
                );

        controls.setAlignment(
                Pos.CENTER
        );

        Runnable update =
                () -> {

                    Mountain m =
                            mountains.get(
                                    galleryIndex
                            );

                    try {

                        Image image =
                                new Image(
                                        m.image,
                                        800,
                                        480,
                                        true,
                                        true,
                                        true
                                );

                        imageView.setImage(
                                image
                        );

                    } catch (Exception ignored) {
                    }

                    name.setText(
                            m.name
                    );

                    description.setText(
                            m.description
                    );

                    counter.setText(
                            (galleryIndex + 1)
                                    + " / "
                                    + mountains.size()
                    );
                };

        previous.setOnAction(
                e -> {

                    galleryIndex--;

                    if (galleryIndex < 0) {
                        galleryIndex =
                                mountains.size() - 1;
                    }

                    update.run();
                }
        );

        next.setOnAction(
                e -> {

                    galleryIndex++;

                    if (galleryIndex >=
                            mountains.size()) {

                        galleryIndex = 0;
                    }

                    update.run();
                }
        );

        gallery.getChildren().addAll(
                imageView,
                name,
                description,
                controls
        );

        root.setCenter(gallery);

        update.run();

        setScene(root);
    }

    // ============================================================
    // STATISTICS
    // ============================================================

    private void showStatistics() {

        BorderPane root =
                new BorderPane();

        root.setStyle(
                "-fx-background-color:" + BG + ";"
        );

        VBox header =
                new VBox(10);

        header.setPadding(
                new Insets(25)
        );

        Button back =
                smallButton("← Home");

        back.setOnAction(
                e -> showDashboard()
        );

        Label title =
                pageTitle(
                        "Himalayan Statistics"
                );

        header.getChildren().addAll(
                back,
                title
        );

        root.setTop(header);

        VBox content =
                new VBox(25);

        content.setPadding(
                new Insets(25)
        );

        HBox stats =
                new HBox(20);

        stats.setAlignment(
                Pos.CENTER
        );

        double highest =
                mountains.stream()
                        .mapToDouble(
                                m -> m.height
                        )
                        .max()
                        .orElse(0);

        long eight =
                mountains.stream()
                        .filter(
                                m -> m.height >= 8000
                        )
                        .count();

        stats.getChildren().addAll(
                statCard(
                        "Major Peaks",
                        "10"
                ),
                statCard(
                        "Highest Peak",
                        String.format(
                                "%,.2f m",
                                highest
                        )
                ),
                statCard(
                        "8000m+ Peaks",
                        String.valueOf(eight)
                ),
                statCard(
                        "Countries",
                        "5+"
                )
        );

        HBox charts =
                new HBox(25);

        BarChart<String, Number>
                barChart =
                createBarChart();

        PieChart pieChart =
                createPieChart();

        charts.getChildren().addAll(
                barChart,
                pieChart
        );

        content.getChildren().addAll(
                stats,
                charts
        );

        ScrollPane scroll =
                new ScrollPane(content);

        scroll.setFitToWidth(true);

        scroll.setStyle(
                "-fx-background:#071923;" +
                "-fx-background-color:#071923;"
        );

        root.setCenter(scroll);

        setScene(root);
    }

    // ============================================================
    // STAT CARD
    // ============================================================

    private VBox statCard(
            String title,
            String value
    ) {

        VBox card =
                new VBox(8);

        card.setAlignment(
                Pos.CENTER
        );

        card.setPrefWidth(220);

        card.setPadding(
                new Insets(25)
        );

        card.setStyle(
                "-fx-background-color:#102d39;" +
                "-fx-background-radius:18;" +
                "-fx-border-color:#1d4c5c;" +
                "-fx-border-radius:18;"
        );

        Label number =
                new Label(value);

        number.setStyle(
                "-fx-text-fill:#8be9fd;" +
                "-fx-font-size:27px;" +
                "-fx-font-weight:bold;"
        );

        Label text =
                new Label(title);

        text.setStyle(
                "-fx-text-fill:#a6bdc5;"
        );

        card.getChildren().addAll(
                number,
                text
        );

        return card;
    }

    // ============================================================
    // BAR CHART
    // ============================================================

    private BarChart<String, Number>
    createBarChart() {

        CategoryAxis xAxis =
                new CategoryAxis();

        NumberAxis yAxis =
                new NumberAxis();

        xAxis.setLabel(
                "Mountain"
        );

        yAxis.setLabel(
                "Height (m)"
        );

        BarChart<String, Number>
                chart =
                new BarChart<>(
                        xAxis,
                        yAxis
                );

        chart.setTitle(
                "Mountain Heights"
        );

        chart.setLegendVisible(false);

        XYChart.Series<String, Number>
                series =
                new XYChart.Series<>();

        List<Mountain> sorted =
                mountains.stream()
                        .sorted(
                                Comparator.comparingDouble(
                                        m -> -m.height
                                )
                        )
                        .collect(
                                Collectors.toList()
                        );

        for (Mountain m : sorted) {

            series.getData().add(
                    new XYChart.Data<>(
                            m.name,
                            m.height
                    )
            );
        }

        chart.getData().add(series);

        chart.setPrefWidth(700);
        chart.setPrefHeight(500);

        return chart;
    }

    // ============================================================
    // PIE CHART
    // ============================================================

    private PieChart createPieChart() {

        PieChart chart =
                new PieChart();

        chart.setTitle(
                "Mountain Height Categories"
        );

        long above8500 =
                mountains.stream()
                        .filter(
                                m -> m.height >= 8500
                        )
                        .count();

        long between =
                mountains.stream()
                        .filter(
                                m -> m.height >= 8000
                                        && m.height < 8500
                        )
                        .count();

        long below =
                mountains.stream()
                        .filter(
                                m -> m.height < 8000
                        )
                        .count();

        chart.setData(
                FXCollections.observableArrayList(
                        new PieChart.Data(
                                "8500m+",
                                above8500
                        ),
                        new PieChart.Data(
                                "8000-8499m",
                                between
                        ),
                        new PieChart.Data(
                                "Below 8000m",
                                below
                        )
                )
        );

        chart.setPrefWidth(500);
        chart.setPrefHeight(500);

        return chart;
    }

    // ============================================================
    // ABOUT
    // ============================================================

    private void showAbout() {

        BorderPane root =
                new BorderPane();

        root.setStyle(
                "-fx-background-color:" + BG + ";"
        );

        VBox header =
                new VBox(10);

        header.setPadding(
                new Insets(25)
        );

        Button back =
                smallButton("← Home");

        back.setOnAction(
                e -> showDashboard()
        );

        Label title =
                pageTitle(
                        "About Himalayan Explorer"
                );

        header.getChildren().addAll(
                back,
                title
        );

        root.setTop(header);

        VBox content =
                new VBox(25);

        content.setAlignment(
                Pos.CENTER
        );

        Label logo =
                new Label("🏔");

        logo.setStyle(
                "-fx-font-size:70px;"
        );

        Label appName =
                new Label(
                        "Himalayan Explorer"
                );

        appName.setStyle(
                "-fx-text-fill:white;" +
                "-fx-font-size:38px;" +
                "-fx-font-weight:bold;"
        );

        Label description =
                new Label(
                        "Himalayan Explorer is an educational " +
                        "JavaFX desktop application designed " +
                        "to explore the Himalayan mountain range.\n\n" +

                        "The application provides information " +
                        "about major peaks, heights, locations, " +
                        "first ascents and interesting facts.\n\n" +

                        "It demonstrates Java Object-Oriented " +
                        "Programming, JavaFX GUI development, " +
                        "collections, searching, sorting and " +
                        "data visualization."
                );

        description.setWrapText(true);
        description.setMaxWidth(700);
        description.setAlignment(
                Pos.CENTER
        );

        description.setStyle(
                "-fx-text-fill:#b5cbd2;" +
                "-fx-font-size:16px;"
        );

        Label technology =
                new Label(
                        "Java 17+ • JavaFX • Maven • OOP"
                );

        technology.setStyle(
                "-fx-text-fill:#8be9fd;" +
                "-fx-font-size:15px;"
        );

        content.getChildren().addAll(
                logo,
                appName,
                description,
                technology
        );

        root.setCenter(content);

        setScene(root);
    }

    // ============================================================
    // UI HELPERS
    // ============================================================

    private Button createButton(
            String text,
            boolean primary
    ) {

        Button button =
                new Button(text);

        if (primary) {

            button.setStyle(
                    "-fx-background-color:#20a4c9;" +
                    "-fx-text-fill:white;" +
                    "-fx-font-weight:bold;" +
                    "-fx-font-size:14px;" +
                    "-fx-padding:12px 24px;" +
                    "-fx-background-radius:25;"
            );

        } else {

            button.setStyle(
                    "-fx-background-color:transparent;" +
                    "-fx-border-color:#73d7ec;" +
                    "-fx-border-width:1.5px;" +
                    "-fx-text-fill:#b9f2ff;" +
                    "-fx-font-weight:bold;" +
                    "-fx-font-size:14px;" +
                    "-fx-padding:11px 24px;" +
                    "-fx-background-radius:25;" +
                    "-fx-border-radius:25;"
            );
        }

        button.setOnMouseEntered(
                e -> button.setOpacity(0.8)
        );

        button.setOnMouseExited(
                e -> button.setOpacity(1)
        );

        return button;
    }

    private Button navButton(
            String text
    ) {

        Button button =
                new Button(text);

        button.setStyle(
                "-fx-background-color:transparent;" +
                "-fx-text-fill:#d9f6ff;" +
                "-fx-font-size:14px;" +
                "-fx-padding:10px 15px;" +
                "-fx-background-radius:20;" +
                "-fx-cursor:hand;"
        );

        button.setOnMouseEntered(
                e -> button.setStyle(
                        "-fx-background-color:#1b5264;" +
                        "-fx-text-fill:white;" +
                        "-fx-font-size:14px;" +
                        "-fx-padding:10px 15px;" +
                        "-fx-background-radius:20;"
                )
        );

        button.setOnMouseExited(
                e -> button.setStyle(
                        "-fx-background-color:transparent;" +
                        "-fx-text-fill:#d9f6ff;" +
                        "-fx-font-size:14px;" +
                        "-fx-padding:10px 15px;" +
                        "-fx-background-radius:20;"
                )
        );

        return button;
    }

    private Button smallButton(
            String text
    ) {

        Button button =
                new Button(text);

        button.setStyle(
                "-fx-background-color:#173d4b;" +
                "-fx-text-fill:white;" +
                "-fx-padding:9px 17px;" +
                "-fx-background-radius:20;" +
                "-fx-cursor:hand;"
        );

        return button;
    }

    private Label pageTitle(
            String text
    ) {

        Label label =
                new Label(text);

        label.setStyle(
                "-fx-text-fill:white;" +
                "-fx-font-size:32px;" +
                "-fx-font-weight:bold;"
        );

        return label;
    }

    // ============================================================
    // SCENE CHANGING WITH FADE ANIMATION
    // ============================================================

    private void setScene(
            BorderPane root
    ) {

        Scene scene =
                new Scene(
                        root,
                        1280,
                        800
                );

        FadeTransition fade =
                new FadeTransition(
                        Duration.millis(400),
                        root
                );

        fade.setFromValue(0);
        fade.setToValue(1);

        fade.play();

        stage.setScene(scene);
    }
}