class Soldier {
    constructor(name, weapon) {
        this._name = name;
        this._weapon = weapon;
        this._health = 20;
    }

    get name() {
        return this._name;
    }

    get health() {
        return this._health;
    }

    incrementHealth(value) {
        this._health = this._health + value;
    }

    get weapon() {
        return this._weapon;
    }

};


class Weapon {
    constructor(weaponName) {
        this._weaponName = weaponName;
        this._dgmOutput = 4;
    }

    get weaponName() {
        return this._weaponName;
    }

    get dgmOutput() {
        return this._dgmOutput;
    }

};


let longsword = new Weapon('longsword');
let shortsword = new Weapon('shortsword');
let longbow = new Weapon('longbow');
let shortbow = new Weapon('shortbow');

let menAtArms = new Soldier('Men-at-arms', longsword);
let shieldsInfantry = new Soldier('Shields', shortsword);
let longbowMan = new Soldier('Longbow Man', longbow);
let shortbowMan = new Soldier('Auxiliaries', shortbow);

console.log("Men-at-arms weapon: " + menAtArms._weapon._weaponName);
console.log("Longbow Man weapon dmg: " + longbowMan._weapon._dgmOutput);
console.log("Shields health: " + shieldsInfantry._health);
console.log("Shields health2: " + shieldsInfantry.health);
shieldsInfantry.incrementHealth(3);
console.log("Shields health after increment: " + shieldsInfantry._health);

