// You can't directly execute SQL in JavaScript, but you can simulate the behavior
class Fruits {
  constructor(name, country) {
    this.name = name;
    this.country = country;
  }
}

class RolesRelations {
  constructor(country, role) {
    this.country = country;
    this.role = role;
  }
}

class Database {
  constructor() {
    this.fruits = [];
    this.rolesRelations = [];
  }

  createFruit(name, country) {
    this.fruits.push(new Fruits(name, country));
  }

  createRolesRelation(country, role) {
    this.rolesRelations.push(new RolesRelations(country, role));
  }

  getCurrentRole() {
    return 'admin'; // Simulate current role
  }

  getRegionalView() {
    const currentRole = this.getCurrentRole();
    const countries = this.rolesRelations
      .filter((relation) => relation.role === currentRole)
      .map((relation) => relation.country);

    return this.fruits.filter((fruit) => countries.includes(fruit.country));
  }
}

// Usage
const db = new Database();
db.createFruit('Apple', 'USA');
db.createFruit('Banana', 'Brazil');
db.createRolesRelation('USA', 'admin');
db.createRolesRelation('Brazil', 'user');

console.log(db.getRegionalView());