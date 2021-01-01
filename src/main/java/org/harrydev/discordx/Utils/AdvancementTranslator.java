package org.harrydev.discordx.Utils;

import lombok.Getter;


@SuppressWarnings({"unused", "SpellCheckingInspection"})
public class AdvancementTranslator {

    public enum story {
        root(                   "Minecraft",                "story/root",                   "The heart and story of the game",              false),
        mine_stone(             "Stone Age",                "story/mine_stone",             "Mine stone with your new pickaxe",             false),
        upgrade_tools(          "Getting an Upgrade",       "story/upgrade_tools",          "Construct a better pickaxe",                   false) ,
        smelt_iron(             "Acquire Hardware",         "story/smelt_iron",             "Smelt an iron ingot",                          false),
        obtain_armor(           "Suit Up",                  "story/obtain_armor",           "Protect yourself with a piece of iron armor",  false),
        lava_bucket(            "Hot Stuff",                "story/lava_bucket",            "Fill a bucket with lava",                      false),
        iron_tools(             "Isn't It Iron Pick",       "story/iron_tools",             "Upgrade your pickaxe",                         false),
        deflect_arrow(          "Not Today, Thank You",     "story/deflect_arrow",          "Deflect a projectile with a shield",           false),
        form_obsidian(          "Ice Bucket Challenge",     "story/form_obsidian",          "Obtain a block of obsidian",                   false),
        mine_diamond(           "Diamonds!",                "story/mine_diamond",           "Acquire diamonds",                             false),
        enter_the_nether(       "We Need to Go Deeper",     "story/enter_the_nether",       "Build, light and enter a Nether Portal",       false),
        shiny_gear(             "Cover Me With Diamonds",   "story/shiny_gear",             "Diamond armor saves lives",                    false),
        enchant_item(           "Enchanter",                "story/enchant_item",           "Enchant an item at an Enchanting Table",       false),
        cure_zombie_villager(   "Zombie Doctor",            "story/cure_zombie_villager",   "Weaken and then cure a Zombie Villager",       false),
        follow_ender_eye(       "Eye Spy",                  "story/follow_ender_eye",       "Follow an Eye of Ender",                       false),
        enter_then_end(         "The End?",                 "story/enter_the_end",          "Enter the End Portal",                         false);

        @Getter
        private final String advancement;
        private final String namespacedID;
        private final String description;
        private final boolean challenge;

        story(String advancement, String namespacedID, String description, boolean challenge) {
            this.advancement = advancement;
            this.namespacedID = namespacedID;
            this.description = description;
            this.challenge = challenge;
        }

        public String getAdvancement() {
            return this.advancement;
        }

        public String getNamespacedID() {
            return this.namespacedID;
        }

        public String getDescription() {
            return this.description;
        }

        public boolean getChallenge() {
            return this.challenge;
        }

        public story getThing() {
            return this;
        }
    }

    public enum nether {
        root(                   "Nether",                       "nether/root",                      "Bring summer clothes",                                                                         false),
        return_to_sender(       "Return to Sender",             "nether/return_to_sender",          "Destroy a Ghast with a fireball",                                                              true),
        find_bastion(           "Those Were the Days",          "nether/find_bastion",              "Enter a Bastion Remnant",                                                                      false),
        obtain_ancient_debris(  "Hidden in the Depths",         "nether/obtain_ancient_debris",     "Obtain Ancient Debris",                                                                        false),
        fast_travel(            "Subspace Bubble",              "nether/fast_travel",               "Use the Nether to travel 7 km in the Overworld",                                               true),
        find_fortress(          "A Terrible Fortress",          "nether/find_fortress",             "Break your way into a Nether Fortress",                                                        false),
        obtain_crying_obsidian( "Who is Cutting Onions?",       "nether/obtain_crying_obsidian",    "Obtain Crying Obsidian",                                                                       false),
        distract_piglin(        "Oh Shiny",                     "nether/distract_piglin",           "Distract Piglins with gold",                                                                   false),
        ride_strider(           "This Boat Has Legs",           "nether/ride_strider",              "Ride a Strider with a Warped Fungus on a Stick",                                               false),
        uneasy_alliance(        "Uneasy Alliance",              "nether/uneasy_alliance",           "Rescue a Ghast from the Nether, bring it safely home to the Overworld... and then kill it",    true),
        loot_bastion(           "War Pigs",                     "nether/loot_bastion",              "Loot a chest in a Bastion Remnant",                                                            false),
        use_lodestone(          "Country Lode, Take Me Home",   "nether/use_lodestone",             "Use a compass on Lodestone",                                                                   false),
        netherite_armor(        "Cover Me in Debris",           "nether/netherite_armor",           "Get a full suit of Netherite armor",                                                           true),
        get_wither_skull(       "Spooky Scary Skeleton",        "nether/get_wither_skull",          "Obtain a Wither Skeleton's skull",                                                             false),
        obtain_blaze_rod(       "Into Fire",                    "nether/obtain_blaze_rod",          "Relieve a Blaze of its rod",                                                                   false),
        charge_respawn_anchor(  "Not Quite \"Nine\" Lives",     "nether/charge_respawn_anchor",     "Charge a Respawn Anchor to the maximum",                                                       false),
        explore_nether(         "Hot Tourist Destinations",     "nether/explore_nether",            "Explore all Nether biomes",                                                                    true),
        summon_wither(          "Withering Heights",            "nether/summon_wither",             "Summon the Wither",                                                                            false),
        brew_potion(            "Local Brewery",                "nether/brew_potion",               "Brew a potion",                                                                                false),
        create_beacon(          "Bring Home the Beacon",        "nether/create_beacon",             "Construct and place a beacon",                                                                 false),
        all_potions(            "A Furious Cocktail",           "nether/all_potions",               "Have every potion effect applied at the same time",                                            true),
        create_full_beacon(     "Beaconator",                   "nether/create_full_beacon",        "Bring a beacon to full power",                                                                 false),
        all_effects(            "How Did We Get Here?",         "nether/all_effects",               "Have every effect applied at the same time",                                                   true);

        @Getter
        private final String advancement;
        private final String namespacedID;
        private final String description;
        private final boolean challenge;

        nether(String advancement, String namespacedID, String description, boolean challenge) {
            this.advancement = advancement;
            this.namespacedID = namespacedID;
            this.description = description;
            this.challenge = challenge;
        }

        public String getAdvancement() {
            return this.advancement;
        }

        public String getNamespacedID() {
            return this.namespacedID;
        }

        public String getDescription() {
            return this.description;
        }

        public boolean getChallenge() {
            return this.challenge;
        }

        public nether getThing() {
            return this;
        }
    }

    public enum end {
        root(               "The End",                          "end/root",                 "Or the beginning?",                                    false),
        kill_dragon(        "Free the End",                     "end/kill_dragon",          "Good luck",                                            false),
        dragon_egg(         "The Next Generation",              "end/dragon_egg",           "Hold the Dragon Egg",                                  false),
        enter_end_gateway(  "Remote Getaway",                   "end/enter_end_gateway",    "Escape the island",                                    false),
        respawn_dragon(     "The End... Again...",              "end/respawn_dragon",       "Respawn the Ender Dragon",                             false),
        dragon_breath(      "You Need a Mint",                  "end/dragon_breath",        "Collect dragon's breath in a glass bottle",            false),
        find_end_city(      "The City at the End of the Game",  "end/find_end_city",        "Go on in, what could happen?",                         false),
        elytra(             "Sky's the Limit",                  "end/elytra",               "Find elytra",                                          false),
        levitate(           "Great View From Up Here",          "end/levitate",             "Levitate up 50 blocks from the attacks of a Shulker",  true);

        @Getter
        private final String advancement;
        private final String namespacedID;
        private final String description;
        private final boolean challenge;

        end(String advancement, String namespacedID, String description, boolean challenge) {
            this.advancement = advancement;
            this.namespacedID = namespacedID;
            this.description = description;
            this.challenge = challenge;
        }

        public String getAdvancement() {
            return this.advancement;
        }

        public String getNamespacedID() {
            return this.namespacedID;
        }

        public String getDescription() {
            return this.description;
        }

        public boolean getChallenge() {
            return this.challenge;
        }

        public end getThing() {
            return this;
        }
    }

    public enum adventure {
        root(                   "Adventure",                "adventure/root",                   "Adventure, exploration, and combat",                                                       false),
        voluntary_exile(        "Voluntary Exile",          "adventure/voluntary_exile",        "Kill a raid captain.\nMaybe consider staying away from villages for the time being...",    false),
        kill_a_mob(             "Monster Hunter",           "adventure/kill_a_mob",             "Kill any hostile monster",                                                                 false),
        trade(                  "What a Deal!",             "adventure/trade",                  "Successfully trade with a Villager",                                                       false),
        honey_block_slide(      "Sticky Situation",         "adventure/honey_block_slide",      "Jump into a Honey Block to break your fall",                                               false),
        ol_betsy(               "Ol' Betsy",                "adventure/ol_betsy",               "Shoot a crossbow",                                                                         false),
        sleep_in_bed(           "Sweet Dreams",             "adventure/sleep_in_bed",           "Sleep in a bed to change your respawn point",                                              false),
        hero_of_the_village(    "Hero of the Village",      "adventure/hero_of_the_village",    "Successfully defend a village from a raid",                                                false),
        throw_trident(          "A Throwaway Joke",         "adventure/throw_trident",          "Throw a trident at something.\nNote: Throwing away your only weapon is not a good idea.",  false),
        shoot_arrow(            "Take Aim",                 "adventure/shoot_arrow",            "Shoot something with an arrow",                                                            false),
        kill_all_mobs(          "Monsters Hunted",          "adventure/kill_all_mobs",          "Kill one of every hostile monster",                                                        true),
        totem_of_undying(       "Postmortal",               "adventure/totem_of_undying",       "Use a Totem of Undying to cheat death",                                                    false),
        summon_iron_golem(      "Hired Help",               "adventure/summon_iron_golem",      "Summon an Iron Golem to help defend a village",                                            false),
        two_birds_one_arrow	(   "Two Birds, One Arrow",     "adventure/two_birds_one_arrow",    "Kill two Phantoms with a piercing arrow",                                                  true),
        whos_the_pillager_now(  "Who's the Pillager Now?",  "adventure/whos_the_pillager_now",  "Give a Pillager a taste of their own medicine",                                            false),
        arbalistic(             "Arbalistic",               "adventure/arbalistic",             "Kill five unique mobs with one crossbow shot",                                             true),
        adventuring_time(       "Adventuring Time",         "adventure/adventuring_time",       "Discover every biome",                                                                     true),
        very_very_frightening(  "Very Very Frightening",    "adventure/very_very_frightening",  "Strike a Villager with lightning",                                                         false),
        sniper_duel(            "Sniper Duel",              "adventure/sniper_duel",            "Kill a Skeleton from at least 50 meters away",                                             true),
        bullseye(               "Bullseye",                 "adventure/bullseye",               "Hit the bullseye of a Target block from at least 30 meters away",                          true);

        @Getter
        private final String advancement;
        private final String namespacedID;
        private final String description;
        private final boolean challenge;

        adventure(String advancement, String namespacedID, String description, boolean challenge) {
            this.advancement = advancement;
            this.namespacedID = namespacedID;
            this.description = description;
            this.challenge = challenge;
        }

        public String getAdvancement() {
            return this.advancement;
        }

        public String getNamespacedID() {
            return this.namespacedID;
        }

        public String getDescription() {
            return this.description;
        }

        public boolean getChallenge() {
            return this.challenge;
        }

        public adventure getThing() {
            return this;
        }
    }

    public enum husbandry {
        root(                   "Husbandry",                "husbandry/root",                   "The world is full of friends and food",                                                        false),
        safely_harvest_honey(   "Bee Our Guest",            "husbandry/safely_harvest_honey",   "Use a Campfire to collect Honey from a Beehive using a Bottle without aggravating the bees",   false),
        breed_an_animal(        "The Parrots and the Bats", "husbandry/breed_an_animal",        "Breed two animals together",                                                                   false),
        tame_an_animal(         "Best Friends Forever",     "husbandry/tame_an_animal",         "Tame an animal",                                                                               false),
        fishy_business(         "Fishy Business",           "husbandry/fishy_business",         "Catch a fish",                                                                                 false),
        silk_touch_nest(        "Total Beelocation",        "husbandry/silk_touch_nest",        "Move a Bee Nest, with 3 bees inside, using Silk Touch",                                        false),
        plant_seed(             "A Seedy Place",            "husbandry/plant_seed",             "Plant a seed and watch it grow",                                                               false),
        bred_all_animals(       "Two by Two",               "husbandry/bred_all_animals",       "Breed all the animals!",                                                                       true),
        complete_catalogue(     "A Complete Catalogue",     "husbandry/complete_catalogue",     "Tame all cat variants!",                                                                       true),
        tactical_fishing(       "Tactical Fishing",         "husbandry/tactical_fishing",       "Catch a fish... without a fishing rod!",                                                       false),
        balanced_diet(          "A Balanced Diet",          "husbandry/balanced_diet",          "Eat everything that is edible, even if it's not good for you",                                 true),
        obtain_netherite_hoe(   "Serious Dedication",       "husbandry/obtain_netherite_hoe",   "Use a Netherite ingot to upgrade a hoe, and then reevaluate your life choices",                true);

        @Getter
        private final String advancement;
        private final String namespacedID;
        private final String description;
        private final boolean challenge;

        husbandry(String advancement, String namespacedID, String description, boolean challenge) {
            this.advancement = advancement;
            this.namespacedID = namespacedID;
            this.description = description;
            this.challenge = challenge;
        }

        public String getAdvancement() {
            return this.advancement;
        }

        public String getNamespacedID() {
            return this.namespacedID;
        }

        public String getDescription() {
            return this.description;
        }

        public boolean getChallenge() {
            return this.challenge;
        }

        public husbandry getThing() {
            return this;
        }
    }
}