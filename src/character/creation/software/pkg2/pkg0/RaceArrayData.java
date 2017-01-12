/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package character.creation.software.pkg2.pkg0;

/**
 *
 * @author Glenn
 */
public class RaceArrayData extends Character{
    
/**===============================================================================================================================/*|*/
/**/static String[] racesArray = {"Dwarf", "Elf", "Gnome", "Half-Elf", "Halfling", "Half-orc", "Human", "Aasimar", "Catfolk",     /*|*/
/**/    "Dhampir", "Drow", "Fetchling", "Goblin", "Hobgoblin", "Ifrit", "Kobold", "Orc", "Oread", "Ratfolk", "Sylph",             /*|*/
/**/    "Tengu (Paizo)", "Tiefling", "Undine", "Changeling", "Duergar (Paizo)", "Gillman", "Grippli", "Kitsune", "Merfolk", 
        "Nagaji", "Samsaran", "Strix", "Suli", "Svirfneblin", "Vanara", "Vishkanya", "Wayang", "Gnoll (Paizo)", 
        "Lizardfolk (Paizo)", "Monkey Goblin", "Skinwalker", "Triaxian", "Android", "Gathlain", "Ghoran", "Kasatha", "Lashunta",
        "Shabti", "Syrinx", "Wyrwood", "Wyvaran", "Centaur (Paizo)", "Ogre", "Shobhad", "Trox", "Drider", "Gargoyle (Paizo)",
        "Sea/Aquatic Elf", "Astomoi", "Caligni", "Deep One Hybrid", "Ganzi", "Kuru", "Munavri", "Orang-Pendak", "Reptoid",
        "Half-Ogre", "ratkin", "Saurian", "Anumus", "Boggle", "Entobian", "Kval", "Mahrog", "Mogogal", "Muse", "Numistian",
        "Oakling", "Obitu", "Relluk", "Squole", "Taddol", "Xax", "Zif", "Blue", "Dromite", "Duergar (DP)","Elan", 
        "Half-Giant", "Maenad", "Ophiduan", "Xeph", "Jonagites", "Half-Faerie Dragon", "High Goblin", "Reaper", "Seedling", 
        "Umbral Kobold", "Angel", "Centaur (LRGG)", "Drakken", "Faun", "Ghost Elf", "Grey", "Grippli", "Lizardfolk (LRGG)",
        "Longblood", "Pariah", "Ratel", "Ravan", "Heckitans", "Sahmeii", "Sproutling", "Tao Reavæn", "Tao Shou", "Vosa", "Darakhul", 
        "Dragonkin", "Gearforged", "Minotaur", "Nkosi", "Tosculi", "Bloodborn", "Cavian", "Cynean", "Dalrean", "Enuka", "Gevet",
        "Kalisan", "Prymidian", "P'Tan", "Sasori", "Monstorin", "Abirai", "Lizardfolk (PFU)","Skindancer", "Svartalfar", 
        "Taninim", "Hengeyokai", "Ironborn", "Jotun", "Kappa", "Tengu (RP)", "Yaksha", "Asterion", "Gnoll (RGG)","Lapith",
        "Piper", "Cloven", "Ponykind", "Jötunfolk", "Automata", "Gargoyle (TPKG)", "Briarborn"};                                                                                                             /*|*/
/**===============================================================================================================================/*|*/
    
/**=====================================================================================================================/*|*/
/**/static String[] incLabels = {"+2 ANY", "+2 WIS\nVARIES", "+2 INT\nVARIES", "+2 STR\nVARIES", "NONE",                /*|*/
/**/    "+2 STR", "+4 STR", "+2 STR\n+2 DEX", "+2 STR\n+4 CON", "+4 STR\n+2 CON", "+2 STR\n+2 CON", "+2 STR\n+2 INT",   /*|*/
/**/    "+4 STR +2 DEX\n+2 CON +2 WIS", "+2 STR +2 DEX\n+4 CON +2 WIS", "+2 STR\n+2 WIS", "+2 STR\n+2 CHA", "+2 DEX",   /*|*/
/**/    "+4 DEX +2 CON\n+2 INT +2 WIS\n+2 CHA", "+2 DEX\n+2 INT\n+2 CHA", "+4 DEX\n+2 WIS", "+4 DEX",                   /*|*/
/**/    "+2 DEX\n+2 CON\n+2 CHA", "+6 DEX\n+2 CON", "+2 DEX\n+2 CON", "+2 DEX\n+2 INT", "+2 DEX\n+2 WIS",               /*|*/
/**/    "+2 DEX\n+2 CHA", "+4 CON", "+2 CON\n+2 INT", "+2 CON\n+2 WIS", "+2 CON\n+2 CHA", "+2 INT", "+2 INT\n+2 WIS",   /*|*/
/**/    "+2 INT\n+2 CHA", "+2 WIS", "+2 WIS\n+2 CHA", "+2 CHA", "VARIES", "+2 CON", "+2 STR\n+2 DEX\n+2 CON"};          /*|*/
/**=====================================================================================================================/*|*/


/**=====================================================================================================================/*|*/



/**=====================================================================================================================/*|*/
/**/static String[] decLabels = {"NONE", "-2 STR", "-2 CON", "-2 WIS", "-2 CHA", "-2 STR\n-2 CHA", "-4 STR\n-2 CON",
        "-2 INT\n-2 WIS\n-2 CHA", "-4 CHA", "-2 INT", "-2 STR\n-4 CHA", "-2 WIS\n-2 CHA", "VARIES", "-2 DEX",
        "-2 INT\n-2 WIS", "-2 CON\n-2 WIS", "-2 DEX\n-2 CHA", "-2 DEX\n-2 WIS", "-4 DEX\n-2 INT\n-4 CHA",
        "-4 INT\n-2 CHA", "-2 INT\n-4 WIS", "-4 INT\n-2 WIS\n-2 CHA"};
/**=====================================================================================================================/*|*/

/**=====================================================================================================================/*|*/
/**/static int[] decRaceLabelLink = {4, 2, 1, 0, 1, 0, 0, 0, 3, 2, 2, 3, 5, 0, 3, 6, 7, 4, 1, 2, 2, 4, 1, 2, 8, 3, 1, 1,/*|*/
/**/    0, 9, 2, 4, 9, 10, 4, 3, 3, 0, 0, 11, 9, 1, 4, 2, 9, 0, 12, 0, 13, 4, 9, 0, 7, 0, 7, 0, 7, 2, 2, 9, 13, 9, 9, 1,/*|*/
/**/    9, 13, 14, 9, 12, 1, 4, 3, 4, 9, 9, 2, 1, 4, 4, 13, 9, 4, 4, 1, 1, 1, 4, 0, 13, 0, 4, 1, 12, 15, 5, 4, 13, 1, 12,  /*|*/
/**/    16, 0, 9, 2, 2, 1, 0, 4, 4, 17, 4, 3, 3, 0, 4, 7, 12, 0, 13, 0, 18, 4, 4, 0, 1, 13, 9, 19, 3, 9, 3, 9, 4, 12, 20,  /*|*/
/**/    9, 2, 2, 13, 12, 12, 9, 0, 2, 3, 9, 0, 0, 3, 0, 13, 4, 12, 21, 0};                                              /*|*/
/**=====================================================================================================================/*|*/

/**=====================================================================================================================/*|*/
/**/static int[] incRaceLabelLink = {29, 24, 30, 0, 26, 0, 0, 35, 26, 26, 26, 26, 20, 23, 26, 16, 6, 14, 24, 24, 25, 24,/*|*/
/**/    25, 35, 29, 30, 35, 26, 21, 15, 32, 16, 15, 25, 25, 26, 24, 10, 10, 20, 1, 29, 24, 26, 30, 25, 2, 30, 34, 24,   /*|*/
/**/    25, 12, 6, 25, 6, 13, 8, 24, 32, 23, 29, 30, 23, 17, 14, 15, 9, 24, 30, 3, 24, 26, 25, 3, 30, 33, 14, 35, 7, 30,/*|*/
/**/    23, 11, 28, 32, 24, 26, 29, 0, 14, 0, 25, 26, 4, 18, 19, 25, 29, 24, 37, 9, 0, 26, 24, 24, 26, 10, 29, 34, 27, 25, 26,   /*|*/
/**/    30, 35, 24, 5, 37, 36, 15, 4, 9, 7, 25, 0, 25, 37, 30, 10, 24, 7, 30, 25, 25, 37, 22, 38, 25, 26, 30, 37, 0, 37,/*|*/
/**/    5, 25, 26, 10, 10, 37, 26, 0, 29, 10, 37, 39, 29};                                                              /*|*/
/**=====================================================================================================================/*|*/

}
