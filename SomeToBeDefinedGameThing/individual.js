

// Defining armorTypes/bodyparts as ENUM...kinda
const ArmorTypes = {
    HEAD: 'HEAD',
    CHEST: 'CHEST',
    BRACERS: 'BRACERS',
    LEGS: 'LEGS',
    FEET: 'FEET'
}


// constructor for Armor items
class Armor {
    constructor(element, name, weightPenalty, drPierce, drSlash, drBlunt) { 
        // where element should use the keys from ArmorTypes
        this._armorType = element;
        this._armorName = name;
        this._weightPenalty = weightPenalty
        this._drPierce = drPierce;
        this._drSlash = drSlash;
        this._drBlunt = drBlunt; 
    }
}

// constructor for Weapon items
class Weapon {
    constructor(weaponName, pierceDmg, slashDmg, bluntDmg, reach, speed, dualHand) { 
        this._weaponName = weaponName;
        this._pierceDmg = pierceDmg;
        this._slashDmg = slashDmg;
        this._bluntDmg = bluntDmg; 
        this._reach = reach; // 1 to  to 8 slots
        this._speed = speed; // 0 to 2 (where is 3 is an added penalty to speed)
        this._dualHand = dualHand; // true or false
    }

};


// constructor for abilities
class Abilities {

}


// constructor for Players/NPCs
class Individual {
    constructor(name, agressiveness, intelligence, strength, dexterity, constitution, warriorClass) {
        this._name = name;

        // how he reacts to positive/negative with positive/negative behaviors
        // scale is 0 to 5
        this._agressiveness = agressiveness;
        
        // scale is 6 to 20
        this._intelligence = intelligence;
        this._strength = strength;
        this._dexterity = dexterity;
        this._constitution = constitution;

        this._health = 100 + (constitution);
        this._stamina = 100 + (constitution);
        this._bodySpeed = dexterity; // same as dexterity and negatively impacted by weapons and armor - calculated upon equipping

        this._warriorClass = warriorClass;

        this._head = noArmorHead;
        this._chest = noArmorChest;
        this._bracers = noArmorBracers;
        this._legs = noArmorLegs;
        this._feet = noArmorFeet;

        this._rightHand = fist;
        this._leftHand = fist;
    }

}

// function to give random number
const randomizer = function(max) {
    let num = Math.ceil(Math.random()*max);
    return num;
}

// SHOW FUNCTIONS

// function to show weapon
const showWeaponStats = (weapon) => console.log(
    `
    name: ${weapon._weaponName}
    pierce dmg: ${weapon._slashDmg} 
    slash dmg: ${weapon._slashDmg}
    blunt dmg: ${weapon._bluntDmg}
    weapon reach: ${weapon._reach}
    weapon speed: ${weapon._speed}
    dualHand: ${weapon._typeHand} 
    `
);

// function to show player/npc stats
const showIndividualStats = (individual) => console.log(
    `
    name: ${individual._name}
    class: ${individual._warriorClass}
    
    traits: 
    agressiveness: ${individual._agressiveness} 
    intelligence: ${individual._intelligence}
    strength: ${individual._strength}
    dexterity: ${individual._dexterity}
    constitution: ${individual._constitution}
    
    current stats:
    health: ${individual._health}
    stamina: ${individual._stamina}
    bodySpeed: ${individual._bodySpeed}

    equipped armor: 
    head: ${individual._head._armorName} & DR: ${individual._head._drPierce + individual._head._drSlash + individual._head._drBlunt}
    chest: ${individual._chest._armorName} + ' & DR: ${individual._chest._drPierce + individual._chest._drSlash + individual._chest._drBlunt}
    bracers: ${individual._bracers._armorName} & DR: ${individual._bracers._drPierce + individual._bracers._drSlash + individual._bracers._drBlunt}
    legs: ${individual._legs._armorName} & DR: ${individual._legs._drPierce + individual._legs._drSlash + individual._legs._drBlunt}
    feet: ${individual._feet._armorName} & DR: ${individual._feet._drPierce + individual._feet._drSlash + individual._feet._drBlunt}

    equipped weapons: 
    Right hand: ${individual._rightHand._weaponName}
    Left hand: ${individual._leftHand._weaponName}
    `
    );


// PLAY FUNCTIONS

// function to equip weapon/shield on right hand
const equipRightHand = function(individual, item) {
    if (item._dualHand == true) {
        individual._rightHand = item;
        individual._leftHand = individual._rightHand;
    }
    individual._rightHand = item;   
    
}

// function to equip weapon/shield on left hand
const equipLeftHand = function(individual, item) {
    if (item._dualHand == true) {
        individual._rightHand = item;
        individual._leftHand = individual._rightHand;
    } 
    individual._leftHand = item;
}

// function to equip armor
// bodyPart should be ArmorTypes.bodyPart
const equipArmor = function(individual, item) {
        let bodyPart = item._armorType;

        switch(bodyPart) {
            case ArmorTypes.HEAD: 
                individual._bodySpeed -= individual._head._weightPenalty;
                individual._head = item; 
                individual._bodySpeed += individual._head._weightPenalty;
                return;

            case ArmorTypes.CHEST:
                individual._bodySpeed -= individual._chest._weightPenalty;
                individual._chest = item;
                individual._bodySpeed += individual._chest._weightPenalty;
                return;

            case ArmorTypes.BRACERS:
                individual._bodySpeed -= individual._bracers._weightPenalty;
                individual._bracers = item;
                individual._bodySpeed += individual._bracers._weightPenalty;
                return;

            case ArmorTypes.LEGS: 
                individual._bodySpeed -= individual._legs._weightPenalty;
                individual._legs = item;
                individual._bodySpeed += individual._legs._weightPenalty;
                return;

            case ArmorTypes.FEET:
                individual._bodySpeed -= individual._feet._weightPenalty;
                individual._feet = item;
                individual._bodySpeed += individual._feet._weightPenalty;
                return;
        }
}

// function to pick body part target when hit
const randomizeAfterHitChance = function(individual) {
    let afterHitChance = randomizer(100);
    console.log(`| afterhitchance is ${afterHitChance} |`);

    if (afterHitChance >= 90) return (individual._head);
    if (afterHitChance >= 50) return (individual._chest);
    if (afterHitChance >= 20) return (individual._legs);
    if (afterHitChance >= 10) return (individual._bracers);
    if (afterHitChance >= 0) return (individual._feet);
    

    }

// function to randomize missed hits messages
const missedHit = function() { 
    let num = randomizer(messages.missedHitMessages.length) -1;
    return messages.missedHitMessages[num];
};

const successHit = function() {
    let num = randomizer(messages.successHitMessages.length) -1;
    let msg = messages.successHitMessages[num];
    return msg;
};



// MESSAGES REPOSITORY

let messages = {
    
    missedHitMessages:
    [
        "Ahh, just missed his head by an inch",
        "He's just too fast for him",
        "Not even close!",
        "Just cutting the air"
    ],

    successHitMessages:
    [
        "What a blow!",
        "Amazing hit!",
        "Well, that will show him!"
    ]

};


// function to calculate a dmg amount
const dmgCalculator = function(individualOne, bodyPartHit) {
    
    let totalPierceDmg = (individualOne._rightHand._pierceDmg) - (bodyPartHit._drPierce); 
    let totalSlashDmg = (individualOne._rightHand._slashDmg) - (bodyPartHit._drSlash);
    let totalBluntDmg = (individualOne._rightHand._bluntDmg) - (bodyPartHit._drBlunt);

    let totalDmg = 
        (totalPierceDmg > 0 ? totalPierceDmg : 0) +
        (totalSlashDmg > 0 ? totalSlashDmg : 0) +
        (totalBluntDmg > 0 ? totalBluntDmg : 0); 

    console.log('| individualOne rightHand pierce dmg: ' + individualOne._rightHand._pierceDmg + ' |');
    console.log('| bodypartHit drPierce: ' + bodyPartHit._drPierce + ' |');
    console.log('| totalPierceDmg: ' + totalPierceDmg + ' |');
    console.log('| totalSlashDmg: ' + totalSlashDmg + ' |');
    console.log('| totalBluntDmg: ' + totalBluntDmg + ' |');

    console.log('| totaldmg is: ' + totalDmg + ' |');
    return totalDmg;
};

// function to apply changes to health
const updateHealth = function(individual, amount) {
    console.log('| individual health before: ' + individual._health + ' |');
    individual._health -= amount; 
    console.log('| health was changed with: ' + amount + ' |')
    console.log('| individual health after: ' + individual._health + ' |');
    }



// STARTING function

const startFight = function(individualOne, individualTwo, battleType, numRounds) { 
    console.log(
    `
    ### --- The fight has begun!! --- ### 
    ### --- ${individualOne._name} faces ${individualTwo._name}! --- ###
    `) 
        
    battleType(individualOne, individualTwo, numRounds);
    //duelRound(individualOne, individualTwo); // calls the function to fight, 1 round 

};

// function to fight
const duelRound = function(individualOne, individualTwo) {
    //console.log('base speed of ' + individualOne._name + ' is ' + individualOne._bodySpeed);
    //console.log('base speed of ' + individualTwo._name + ' is ' + individualTwo._bodySpeed);
    
    let attackSpeed = randomizer(individualOne._bodySpeed);
    let defenseSpeed = randomizer(individualTwo._bodySpeed);
    let hitChance = attackSpeed-defenseSpeed;

    // in case we want to see the individual rolls:
    console.log(
    `
    | hidden info |
    | ${individualOne._name} attacks with a roll of ${attackSpeed} and ${individualTwo._name} defends with a roll of ${defenseSpeed} |
    | hit chance is ${hitChance} |
    `
    );
    
    if (hitChance > 0) {
        
        let bodyPartHit = randomizeAfterHitChance(individualTwo); // to pick hit body part. Inside this variable is now the equipped armor part. 
        let totalDmgTaken = dmgCalculator(individualOne, bodyPartHit); // will store a positive number.
        updateHealth(individualTwo, totalDmgTaken);

        console.log(`
        ### --- ${successHit()} A mighty blow in the ${bodyPartHit._armorName} --- ###
        `);

        return;
    }

    console.log(missedHit());
};




// function for battleType - if it's a set number of rounds or until 0 health
let battleTypes = {
    battleTillDeath: function(individualOne, individualTwo) {
        if (individualOne._health <= 0 || individualTwo._health <= 0) {
            let winner = individualOne; // winner is individualOne, except if his health is 0 (doesn't fix eventual ties);
                if (individualOne._health <= 0) winner = individualTwo; 
            console.log(`
            ### --- The fight is over! Winner is ${winner._name}
            `)
            return;
        };
        duelRound(individualOne, individualTwo);
        duelRound(individualTwo, individualOne); // since the duelRound translates in a single attack/defend event, so they can swap. 
        battleTypes.battleTillDeath(individualOne, individualTwo);
    }, 

    battlePerRounds: function(individualOne, individualTwo, numRounds) {
        let numRoundsLeft = numRounds;
        if (numRoundsLeft == 0) {
            console.log('fight is over')
            return;
        }
        numRoundsLeft--; 
        duelRound(individualOne, individualTwo);
        duelRound(individualTwo, IndividualOne);
        battleTypes.battlePerRounds(individualOne, individualTwo, numRoundsLeft);
    },
};




// SETTING ENVIRONMENT

// creating test armor sets
const noArmorHead = new Armor(ArmorTypes.HEAD, 'empty', 0, 0, 0, 0);
const noArmorChest = new Armor(ArmorTypes.CHEST, 'empty', 0, 0, 0, 0);
const noArmorLegs = new Armor(ArmorTypes.LEGS, 'empty', 0, 0, 0, 0);
const noArmorBracers = new Armor(ArmorTypes.BRACERS, 'empty', 0, 0, 0, 0);
const noArmorFeet = new Armor(ArmorTypes.FEET, 'empty', 0, 0, 0, 0);

const steelCap = new Armor(ArmorTypes.HEAD,'Steel cap', 1, 3, 6, 2);
const steelMailPlate = new Armor(ArmorTypes.CHEST, 'Steel mail plate', 3, 3, 6, 4);
const leatherGloves = new Armor(ArmorTypes.BRACERS, 'Leather gloves', 0, 1, 2, 2); 
const steelMailLegs = new Armor(ArmorTypes.LEGS, 'Steel mail legs', 3, 3, 6, 4);
const leatherBoots = new Armor(ArmorTypes.FEET, 'Leather boots', 0, 1, 2, 2);

// creating test weapons
//weaponName, pierceDmg, slashDmg, bluntDmg, reach, speed, dualHand
const fist = new Weapon('Fist', 0, 0, 2, 1, 0, false);
const longsword = new Weapon('Longsword', 6, 12, 2, 1, 2, false);
const shortsword = new Weapon('Shortsword', 8, 4, 0, 1, 1, false);
const longbow = new Weapon('Longbow', 8, 0, 0, 8, 3, true);
const spear = new Weapon('Spear', 12, 1, 0, 2, 2, true);
const dagger = new Weapon('Dagger', 5, 0, 0, 1, 0, false);
const smallshield = new Weapon('Small shield', 0, 0, 2, 1, 4, false);

// creating test individuals
let Jack = new Individual('Jack', 1, 15, 16, 12, 20, 'Fighter');
let Mario = new Individual('Mario', 4, 12, 14, 16, 12, 'Archer');
let Vincent = new Individual('Vincent', 3, 15, 19, 11, 8, 'Vanguard')


// setting up equipment on test individuals
equipRightHand(Mario, longbow);
equipArmor(Mario, steelCap);
equipArmor(Mario, steelMailPlate);
equipArmor(Mario, steelMailLegs);
equipArmor(Mario, leatherBoots);
equipArmor(Mario, leatherGloves);

equipRightHand(Jack, longsword);
equipArmor(Jack, steelCap);
equipArmor(Jack, steelMailPlate);
equipArmor(Jack, steelMailLegs);
equipArmor(Jack, leatherBoots);
equipArmor(Jack, leatherGloves);




// ACTION

startFight(Mario, Jack, battleTypes.battleTillDeath);

//startFight(Mario, Jack, battleTypes.battlePerRounds, 2);



