export class Player {
    id: number;
    name: string;
    victories: number;
    matches: number;

    constructor(id: number, name: string, victories: number, matches: number) { 
        this.id = id;
        this.name = name;
        this.victories = victories;
        this.matches = matches;
    }
}
