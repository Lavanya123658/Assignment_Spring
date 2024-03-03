export class LeaveType {
  id: number;
  name: string;
  maxLeaves: number;

  constructor(id: number, name: string, maxLeaves: number) {
    this.id = id;
    this.name = name;
    this.maxLeaves = maxLeaves;
  }
}
