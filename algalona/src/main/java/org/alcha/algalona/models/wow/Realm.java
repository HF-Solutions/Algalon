package org.alcha.algalona.models.wow;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Created by Alcha on 8/8/2017.</p>
 */

public class Realm {
    public enum Name {
        Akama("Akama"),
        Altar_of_Storms("Altar of Storms"),
        Alterac_Mountains("Alterac Mountains"),
        Andorhal("Andorhal"),
        Anvilmar("Anvilmar"),
        Azgalor("Azgalor"),
        Azralon("Azralon"),
        Barthilas("Barthilas"),
        Black_Dragonflight("Black Dragonflight"),
        Blackwater_Raiders("Blackwater Raiders"),
        Blackwing_Lair("Blackwing Lair"),
        Bleeding_Hollow("Bleeding Hollow"),
        Blood_Furnace("Blood Furnace"),
        Bonechewer("Bonechewer"),
        Borean_Tundra("Borean Tundra"),
        Caelestrasz("Caelestrasz"),
        Cairne("Cairne"),
        Cenarion_Circle("Cenarion Circle"),
        Cenarius("Cenarius"),
        Coilfang("Coilfang"),
        Dark_Iron("Dark Iron"),
        Darrowmere("Darrowmere"),
        DathRemar("Dath'Remar"),
        Dawnbringer("Dawnbringer"),
        Demon_Soul("Demon Soul"),
        Detheroc("Detheroc"),
        DrakTharon("Drak'Tharon"),
        Draka("Draka"),
        Drakkari("Drakkari"),
        Dreadmaul("Dreadmaul"),
        Drenden("Drenden"),
        Duskwood("Duskwood"),
        Echo_Isles("Echo Isles"),
        Emerald_Dream("Emerald Dream"),
        Farstriders("Farstriders"),
        Feathermoon("Feathermoon"),
        Fenris("Fenris"),
        Firetree("Firetree"),
        Fizzcrank("Fizzcrank"),
        Galakrond("Galakrond"),
        Gallywix("Gallywix"),
        Garithos("Garithos"),
        Garrosh("Garrosh"),
        Gnomeregan("Gnomeregan"),
        Goldrinn("Goldrinn"),
        Gorefiend("Gorefiend"),
        Greymane("Greymane"),
        Grizzly_Hills("Grizzly Hills"),
        Gundrak("Gundrak"),
        Gurubashi("Gurubashi"),
        Hydraxis("Hydraxis"),
        Icecrown("Icecrown"),
        JubeiThos("Jubei'Thos"),
        Kaelthas("Kael'thas"),
        Kalecgos("Kalecgos"),
        Kiljaeden("Kil'jaeden"),
        Korgath("Korgath"),
        Korialstrasz("Korialstrasz"),
        Lethon("Lethon"),
        Lightninghoof("Lightninghoof"),
        Llane("Llane"),
        Madoran("Madoran"),
        Maelstrom("Maelstrom"),
        Maiev("Maiev"),
        Malorne("Malorne"),
        Misha("Misha"),
        MokNathal("Mok'Nathal"),
        Moon_Guard("Moon Guard"),
        Moonrunner("Moonrunner"),
        Muradin("Muradin"),
        Nazgrel("Nazgrel"),
        Nesingwary("Nesingwary"),
        Queldorei("Quel'dorei"),
        Rivendare("Rivendare"),
        Scarlet_Crusade("Scarlet Crusade"),
        Scilla("Scilla"),
        Sentinels("Sentinels"),
        Shadow_Council("Shadow Council"),
        Shadowmoon("Shadowmoon"),
        Shandris("Shandris"),
        Shuhalo("Shu'halo"),
        Silver_Hand("Silver Hand"),
        Sisters_of_Elune("Sisters of Elune"),
        Skywall("Skywall"),
        Smolderthorn("Smolderthorn"),
        Spirestone("Spirestone"),
        Staghelm("Staghelm"),
        Stonemaul("Stonemaul"),
        Tanaris("Tanaris"),
        Thaurissan("Thaurissan"),
        The_Forgotten_Coast("The Forgotten Coast"),
        The_Scryers("The Scryers"),
        The_Underbog("The Underbog"),
        The_Venture_Co("The Venture Co"),
        Thorium_Brotherhood("Thorium Brotherhood"),
        Thunderlord("Thunderlord"),
        Tol_Barad("Tol Barad"),
        Tortheldrin("Tortheldrin"),
        Undermine("Undermine"),
        Ursin("Ursin"),
        Uther("Uther"),
        Velen("Velen"),
        Warsong("Warsong"),
        Whisperwind("Whisperwind"),
        Windrunner("Windrunner"),
        Winterhoof("Winterhoof"),
        Wyrmrest_Accord("Wyrmrest Accord"),
        Zangarmarsh("Zangarmarsh"),
        Aegwynn("Aegwynn"),
        Aerie_Peak("Aerie Peak"),
        Agamaggan("Agamaggan"),
        Aggramar("Aggramar"),
        AhnQiraj("Ahn'Qiraj"),
        AlAkir("Al'Akir"),
        Alexstrasza("Alexstrasza"),
        Alleria("Alleria"),
        Alonsus("Alonsus"),
        AmanThul("Aman'Thul"),
        Ambossar("Ambossar"),
        Anachronos("Anachronos"),
        Anetheron("Anetheron"),
        Antonidas("Antonidas"),
        Anubarak("Anub'arak"),
        Arakarahm("Arak-arahm"),
        Arathi("Arathi"),
        Arathor("Arathor"),
        Archimonde("Archimonde"),
        Area_52("Area 52"),
        Argent_Dawn("Argent Dawn"),
        Arthas("Arthas"),
        Arygos("Arygos"),
        Aszune("Aszune"),
        Auchindoun("Auchindoun"),
        AzjolNerub("Azjol-Nerub"),
        Azshara("Azshara"),
        Azuremyst("Azuremyst"),
        Baelgun("Baelgun"),
        Balnazzar("Balnazzar"),
        Blackhand("Blackhand"),
        Blackmoore("Blackmoore"),
        Blackrock("Blackrock"),
        Bladefist("Bladefist"),
        Blades_Edge("Blade's Edge"),
        Bloodfeather("Bloodfeather"),
        Bloodhoof("Bloodhoof"),
        Bloodscalp("Bloodscalp"),
        Blutkessel("Blutkessel"),
        Boulderfist("Boulderfist"),
        Bronze_Dragonflight("Bronze Dragonflight"),
        Bronzebeard("Bronzebeard"),
        Burning_Blade("Burning Blade"),
        Burning_Legion("Burning Legion"),
        Burning_Steppes("Burning Steppes"),
        Chamber_of_Aspects("Chamber of Aspects"),
        Chogall("Cho'gall"),
        Chromaggus("Chromaggus"),
        Colinas_Pardas("Colinas Pardas"),
        Conseil_des_Ombres("Conseil des Ombres"),
        Crushridge("Crushridge"),
        CThun("C'Thun"),
        Culte_de_la_Rive_Noire("Culte de la Rive Noire"),
        Daggerspine("Daggerspine"),
        Dalaran("Dalaran"),
        Dalvengyr("Dalvengyr"),
        Darkmoon_Faire("Darkmoon Faire"),
        Darksorrow("Darksorrow"),
        Darkspear("Darkspear"),
        Das_Konsortium("Das Konsortium"),
        Das_Syndikat("Das Syndikat"),
        Deathwing("Deathwing"),
        Defias_Brotherhood("Defias Brotherhood"),
        Dentarg("Dentarg"),
        Der_abyssische_Rat("Der abyssische Rat"),
        Der_Mithrilorden("Der Mithrilorden"),
        Der_Rat_von_Dalaran("Der Rat von Dalaran"),
        Destromath("Destromath"),
        Dethecus("Dethecus"),
        Die_Aldor("Die Aldor"),
        Die_Arguswacht("Die Arguswacht"),
        Die_ewige_Wacht("Die ewige Wacht"),
        Die_Nachtwache("Die Nachtwache"),
        Die_Silberne_Hand("Die Silberne Hand"),
        Die_Todeskrallen("Die Todeskrallen"),
        Doomhammer("Doomhammer"),
        Draenor("Draenor"),
        Dragonblight("Dragonblight"),
        Dragonmaw("Dragonmaw"),
        Drakthul("Drak'thul"),
        DrekThar("Drek'Thar"),
        Dun_Modr("Dun Modr"),
        Dun_Morogh("Dun Morogh"),
        Dunemaul("Dunemaul"),
        Durotan("Durotan"),
        Earthen_Ring("Earthen Ring"),
        Echsenkessel("Echsenkessel"),
        Eitrigg("Eitrigg"),
        EldreThalas("Eldre'Thalas"),
        Elune("Elune"),
        Emeriss("Emeriss"),
        Eonar("Eonar"),
        Eredar("Eredar"),
        Executus("Executus"),
        Exodar("Exodar"),
        Forscherliga("Forscherliga"),
        Frostmane("Frostmane"),
        Frostmourne("Frostmourne"),
        Frostwhisper("Frostwhisper"),
        Frostwolf("Frostwolf"),
        Garona("Garona"),
        Genjuros("Genjuros"),
        Ghostlands("Ghostlands"),
        Gilneas("Gilneas"),
        Gorgonnash("Gorgonnash"),
        Grim_Batol("Grim Batol"),
        Guldan("Gul'dan"),
        Hakkar("Hakkar"),
        Haomarush("Haomarush"),
        Hellfire("Hellfire"),
        Hellscream("Hellscream"),
        Hyjal("Hyjal"),
        Illidan("Illidan"),
        Jaedenar("Jaedenar"),
        KaelThas("Kael'Thas"),
        Karazhan("Karazhan"),
        Kargath("Kargath"),
        Kazzak("Kazzak"),
        KelThuzad("Kel'Thuzad"),
        Khadgar("Khadgar"),
        Khaz_Modan("Khaz Modan"),
        Khazgoroth("Khaz'goroth"),
        KilJaeden("Kil'Jaeden"),
        Kilrogg("Kilrogg"),
        Kirin_Tor("Kirin Tor"),
        Korgall("Kor'gall"),
        Kragjin("Krag'jin"),
        Krasus("Krasus"),
        Kul_Tiras("Kul Tiras"),
        Kult_der_Verdammten("Kult der Verdammten"),
        Laughing_Skull("Laughing Skull"),
        Les_Clairvoyants("Les Clairvoyants"),
        Les_Sentinelles("Les Sentinelles"),
        Lightbringer("Lightbringer"),
        Lightnings_Blade("Lightning's Blade"),
        Lordaeron("Lordaeron"),
        Los_Errantes("Los Errantes"),
        Lothar("Lothar"),
        Madmortem("Madmortem"),
        Magtheridon("Magtheridon"),
        Malfurion("Malfurion"),
        MalGanis("Mal'Ganis"),
        Malygos("Malygos"),
        Mannoroth("Mannoroth"),
        Mazrigos("Mazrigos"),
        Medivh("Medivh"),
        Minahonda("Minahonda"),
        Moonglade("Moonglade"),
        Mugthol("Mug'thol"),
        Nagrand("Nagrand"),
        Nathrezim("Nathrezim"),
        Naxxramas("Naxxramas"),
        Nazjatar("Nazjatar"),
        Nefarian("Nefarian"),
        Nemesis("Nemesis"),
        Neptulon("Neptulon"),
        Nerathor("Nera'thor"),
        Nerzhul("Ner'zhul"),
        Nethersturm("Nethersturm"),
        Nordrassil("Nordrassil"),
        Norgannon("Norgannon"),
        Nozdormu("Nozdormu"),
        Onyxia("Onyxia"),
        Outland("Outland"),
        Perenolde("Perenolde"),
        Proudmoore("Proudmoore"),
        QuelThalas("Quel'Thalas"),
        Ragnaros("Ragnaros"),
        Rajaxx("Rajaxx"),
        Rashgarroth("Rashgarroth"),
        Ravencrest("Ravencrest"),
        Ravenholdt("Ravenholdt"),
        Rexxar("Rexxar"),
        Runetotem("Runetotem"),
        Sanguino("Sanguino"),
        Sargeras("Sargeras"),
        Saurfang("Saurfang"),
        Scarshield_Legion("Scarshield Legion"),
        Senjin("Sen'jin"),
        Shadowsong("Shadowsong"),
        Shattered_Halls("Shattered Halls"),
        Shattered_Hand("Shattered Hand"),
        Shattrath("Shattrath"),
        Shendralar("Shen'dralar"),
        Silvermoon("Silvermoon"),
        Sinstralis("Sinstralis"),
        Skullcrusher("Skullcrusher"),
        Spinebreaker("Spinebreaker"),
        Sporeggar("Sporeggar"),
        Steamwheedle_Cartel("Steamwheedle Cartel"),
        Stormrage("Stormrage"),
        Stormreaver("Stormreaver"),
        Stormscale("Stormscale"),
        Sunstrider("Sunstrider"),
        Suramar("Suramar"),
        Sylvanas("Sylvanas"),
        Taerar("Taerar"),
        Talnivarr("Talnivarr"),
        V_Mill("Tarren Mill"),
        Teldrassil("Teldrassil"),
        Temple_noir("Temple noir"),
        Terenas("Terenas"),
        Terokkar("Terokkar"),
        Terrordar("Terrordar"),
        The_Maelstrom("The Maelstrom"),
        The_Shatar("The Sha'tar"),
        The_Venture_Co_EU("The Venture Co EU"),
        Theradras("Theradras"),
        Thrall("Thrall"),
        ThrokFeroth("Throk'Feroth"),
        Thunderhorn("Thunderhorn"),
        Tichondrius("Tichondrius"),
        Tirion("Tirion"),
        Todeswache("Todeswache"),
        Trollbane("Trollbane"),
        Turalyon("Turalyon"),
        Twilights_Hammer("Twilight's Hammer"),
        Twisting_Nether("Twisting Nether"),
        Tyrande("Tyrande"),
        Uldaman("Uldaman"),
        Uldum("Uldum"),
        UnGoro("Un'Goro"),
        Varimathras("Varimathras"),
        Vashj("Vashj"),
        Veklor("Vek'lor"),
        Veknilash("Vek'nilash"),
        Voljin("Vol'jin"),
        Wildhammer("Wildhammer"),
        Wrathbringer("Wrathbringer"),
        Xavius("Xavius"),
        Ysera("Ysera"),
        Ysondre("Ysondre"),
        Zenedar("Zenedar"),
        Zirkel_des_Cenarius("Zirkel des Cenarius"),
        Zuljin("Zul'jin"),
        Zuluhed("Zuluhed"),
        Азурегос("Азурегос"),
        Борейская_тундра("Борейская тундра"),
        Вечная_Песня("Вечная Песня"),
        Дракономор("Дракономор"),
        Галакронд("Галакронд"),
        Голдринн("Голдринн"),
        Гордунни("Гордунни"),
        Гром("Гром"),
        Корольлич("Король-лич"),
        Подземье("Подземье"),
        Разувий("Разувий"),
        Ревущий_фьорд("Ревущий фьорд"),
        Свежеватель_Душ("Свежеватель Душ"),
        Седогрив("Седогрив"),
        Страж_Смерти("Страж Смерти"),
        Термоштепсель("Термоштепсель"),
        Ткач_Смерти("Ткач Смерти"),
        Черный_Шрам("Черный Шрам"),
        Ясеневый_лес("Ясеневый лес"),
        Unknown("Unknown");

        public String name;
        public String slug;

        Name(String name) {
            this.name = name;
        }

        /**
         * Returns the slug representation of the given {@link Realm realm name} to be used in
         * a url request.
         *
         * @return Server name without spaces or apostrophes
         */
        public String getSlug() {
            if (slug == null)
                return this.toString().toLowerCase().replace('_', '-');
            else return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public String getRelativeUrl() {
            if (name.contains("\'")) {
                return name.toLowerCase().replace("_", "%20");
            } else {
                return this.toString().toLowerCase().replace("_", "%20");
            }
        }

        public String getName() {
            return name;
        }

        public String toString() {
            return name;
        }

        public static Realm.Name fromString(String name) {
            for (Realm.Name realm : Realm.Name.values()) {
                if (realm.getName().equalsIgnoreCase(name)) return realm;
            }

            return Unknown;
        }
    }

    public enum Type {
        PVP,
        PVE,
        RP,
        UNKNOWN;

        @Override
        public String toString() {
            return name().toLowerCase();
        }

        public String getName() {
            return name().toLowerCase();
        }

        public static Type fromString(String string) {
            for (Type type : Type.values())
                if (type.toString().equalsIgnoreCase(string)) return type;

            return Type.UNKNOWN;
        }
    }

    public enum Population {
        High,
        Medium,
        Low,
        Full,
        Undefined;

        public static Population fromString(String string) {
            for (Population population : Population.values()) {
                if (population.name().equalsIgnoreCase(string)) return population;
            }

            return Undefined;
        }
    }

    private Type mType;
    private Population mPopulation;
    private boolean mQueue;
    private boolean mStatus;
    private Name mName;
    private String mSlug;
    private Battlegroup mBattlegroup;
    private Locale mLocale;
    private String mTimezone;
    private List<Realm> mConnectedRealms;

    @Override
    public String toString() {
        if (getName() != null)
            return getName().toString();
        else if (mSlug != null) return mSlug;
        else if (mLocale != null) return mLocale.toString();
        else return "Unknown";
    }

    public static Realm fromString(String name) {
        Realm realm = new Realm();
        realm.setName(Name.fromString(name));
        return realm;
    }

    public static Realm newInstanceFromJson(JsonObject jsonObject) {
        Realm realm = new Realm();

        if (jsonObject.has("realm"))
            realm.setName(Name.fromString(jsonObject.get("realm").getAsString()));

        if (jsonObject.has("name"))
            realm.setName(Name.fromString(jsonObject.get("name").getAsString()));
        else realm.setName(Name.Unknown);

        if (jsonObject.has("slug"))
            realm.setSlug(jsonObject.get("slug").getAsString());
        else realm.setSlug(null);

        if (jsonObject.has("battlegroup"))
            realm.setBattlegroup(Battlegroup.fromString(jsonObject.get("battlegroup").getAsString()));
        else {
            Battlegroup battlegroup = new Battlegroup();
            battlegroup.setName(Battlegroup.Name.Unknown);
            realm.setBattlegroup(battlegroup);
        }

        if (jsonObject.has("locale"))
            realm.setLocale(Locale.fromString(jsonObject.get("locale").getAsString()));
        else realm.setLocale(Locale.fromString(""));

        if (jsonObject.has("connected_realms")) {
            JsonArray temp = jsonObject.getAsJsonArray("connected_realms");
            List<Realm> realms = new ArrayList<>();

            for (int x = 0; x < temp.size(); x++) {
                String tempStr = temp.get(x).getAsString();
                realms.add(Realm.fromString(tempStr));
            }

            realm.setConnectedRealms(realms);
        }

        if (jsonObject.has("population"))
            realm.setPopulation(Population.fromString(jsonObject.get("population").getAsString()));
        else realm.setPopulation(Population.Undefined);

        if (jsonObject.has("queue"))
            realm.setQueue(jsonObject.get("queue").getAsBoolean());
        else realm.setQueue(false);

        if (jsonObject.has("status"))
            realm.setStatus(jsonObject.get("status").getAsBoolean());
        else realm.setStatus(false);

        return realm;
    }

    public static List<Realm> convertJSONArray(JsonArray array) {
        List<Realm> tempRealms = new ArrayList<>();

        for (JsonElement element : array)
            tempRealms.add(Realm.newInstanceFromJson(element.getAsJsonObject()));

        return tempRealms;
    }

    public void setName(Name name) {
        mName = name;
    }

    public Name getName() {
        return mName;
    }

    public void setSlug(String slug) {
        mSlug = slug;
    }

    public String getSlug() {
        return mSlug;
    }

    public String getRelativeUrl() {
        return getName().toString().toLowerCase().replace("_", "%20");
    }

    public Battlegroup getBattlegroup() {
        return mBattlegroup;
    }

    public void setBattlegroup(Battlegroup battlegroup) {
        mBattlegroup = battlegroup;
    }

    public Locale getLocale() {
        return mLocale;
    }

    public void setLocale(Locale locale) {
        mLocale = locale;
    }

    public String getTimezone() {
        return mTimezone;
    }

    public void setTimezone(String timezone) {
        mTimezone = timezone;
    }

    public List<Realm> getConnectedRealms() {
        return mConnectedRealms;
    }

    public void setConnectedRealms(List<Realm> connectedRealms) {
        mConnectedRealms = connectedRealms;
    }

    public Type getType() {
        return mType;
    }

    public void setType(Type type) {
        mType = type;
    }

    public Population getPopulation() {
        return mPopulation;
    }

    public void setPopulation(Population population) {
        mPopulation = population;
    }

    public boolean isQueue() {
        return mQueue;
    }

    public void setQueue(boolean queue) {
        mQueue = queue;
    }

    public boolean isStatus() {
        return mStatus;
    }

    public void setStatus(boolean status) {
        mStatus = status;
    }
}
