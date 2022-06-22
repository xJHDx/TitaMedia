export class RealizarPagoModels {
    constructor(
        public bancoId?: number,
        public usuarioId?: number,
        public valorPagado?: number,
        public fechaPago?: Date
    ) {}
}