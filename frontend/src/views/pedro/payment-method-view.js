import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-date-picker/src/vaadin-date-picker.js';
import '@vaadin/vaadin-form-layout/src/vaadin-form-item.js';
import '@vaadin/vaadin-form-layout/vaadin-form-item.js';
import '@vaadin/vaadin-text-field/src/vaadin-number-field.js';
import '@vaadin/vaadin-form-layout/src/vaadin-form-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-form-layout/vaadin-form-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';

class PaymentMethodView extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout theme="spacing">
 <img src="frontend/images/visa-mastercard.png" alt="payments" id="img" style="align-self: center; width:300px;height:100px;">
</vaadin-vertical-layout>
<vaadin-form-layout style="width: 100%;">
 <vaadin-form-item>
  <label slot="label">Tarjeta Numero</label>
  <vaadin-number-field style="width: 70%;" required invalid></vaadin-number-field>
 </vaadin-form-item>
 <vaadin-form-item>
  <label slot="label">Vence</label>
  <vaadin-date-picker style="width: 70%;" required></vaadin-date-picker>
 </vaadin-form-item>
 <vaadin-form-item>
  <label slot="label" style="flex-grow: 0; flex-shrink: 0;">Codigo de Seguridad</label>
  <vaadin-number-field minlength="2" required maxlength="3" style="width: 70%; height: 100%;" invalid></vaadin-number-field>
 </vaadin-form-item>
 <vaadin-form-item>
  <label slot="label">Nombre</label>
  <vaadin-number-field minlength="2" required maxlength="3" style="width: 70%;" invalid></vaadin-number-field>
 </vaadin-form-item>
</vaadin-form-layout>
<div>
 <p style="text-align: center;background-color: lightblue;">Configuracion de Pago</p>
 <vaadin-vertical-layout theme="spacing">
  <label style="align-self: center;">$75 durante 2 quincenas</label>
  <label style="align-self: center;">$50 durante 4 meses</label>
  <label style="align-self: center;">$90 durante 2 meses</label>
 </vaadin-vertical-layout>
</div>
<div>
 <vaadin-vertical-layout theme="spacing">
  <label style="align-self: flex-end; padding: var(--lumo-space-l);">Total a Pagar: $570</label>
  <label style="align-self: flex-end; padding: var(--lumo-space-l);">Ultimo Pago 01/08/2020</label>
  <vaadin-button style="align-self: center;">
    Suscribir Metodo de Pago 
  </vaadin-button>
 </vaadin-vertical-layout>
</div>
`;
    }

    static get is() {
        return 'payment-method-view';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(PaymentMethodView.is, PaymentMethodView);
