<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

		<aside id="sidebar">
			<div class="d-flex">
				<button class="toggle-btn" type="button">
					<svg xmlns="http://www.w3.org/2000/svg"
						class="icon icon-tabler icon-tabler-layout-grid" width="24"
						height="24" viewBox="0 0 24 24" stroke-width="1.5"
						stroke="#ffffff" fill="none" stroke-linecap="round"
						stroke-linejoin="round">
              <path stroke="none" d="M0 0h24v24H0z" fill="none" />
              <path
							d="M4 4m0 1a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v4a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1z" />
              <path
							d="M14 4m0 1a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v4a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1z" />
              <path
							d="M4 14m0 1a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v4a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1z" />
              <path
							d="M14 14m0 1a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v4a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1z" />
            </svg>
				</button>
				<div class="sidebar-logo">
					<a href="${pageContext.request.contextPath}">Alke Wallet</a>
				</div>
			</div>
			<ul class="sidebar-nav">
				<li class="sidebar-item"><a href="${pageContext.request.contextPath}"
					class="sidebar-link"> <svg xmlns="http://www.w3.org/2000/svg"
							class="icon icon-tabler icon-tabler-home" width="24" height="24"
							viewBox="0 0 24 24" stroke-width="1.5" stroke="#ffffff"
							fill="none" stroke-linecap="round" stroke-linejoin="round">
                <path stroke="none" d="M0 0h24v24H0z" fill="none" />
                <path d="M5 12l-2 0l9 -9l9 9l-2 0" />
                <path d="M5 12v7a2 2 0 0 0 2 2h10a2 2 0 0 0 2 -2v-7" />
                <path d="M9 21v-6a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2v6" />
              </svg> <span>Menu</span>
				</a></li>
				<li class="sidebar-item"><a href="#"
					class="sidebar-link collapsed has-dropdown"
					data-bs-toggle="collapse" data-bs-target="#contactos"
					aria-expanded="false" aria-controls="contactos"> <svg
							xmlns="http://www.w3.org/2000/svg"
							class="icon icon-tabler icon-tabler-address-book" width="24"
							height="24" viewBox="0 0 24 24" stroke-width="1.5"
							stroke="#ffffff" fill="none" stroke-linecap="round"
							stroke-linejoin="round">
                <path stroke="none" d="M0 0h24v24H0z" fill="none" />
                <path
								d="M20 6v12a2 2 0 0 1 -2 2h-10a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h10a2 2 0 0 1 2 2z" />
                <path d="M10 16h6" />
                <path d="M13 11m-2 0a2 2 0 1 0 4 0a2 2 0 1 0 -4 0" />
                <path d="M4 8h3" />
                <path d="M4 12h3" />
                <path d="M4 16h3" />
              </svg> <span>Contactos</span>
				</a>
					<ul id="contactos" class="sidebar-dropdown list-unstyled collapse"
						data-bs-parent="#sidebar">
						<li class="sidebar-item"><a href="${pageContext.request.contextPath}/AgregarContacto"
							class="sidebar-link">Agregar</a></li>
						<li class="sidebar-item"><a href="${pageContext.request.contextPath}/ListarContactos"
							class="sidebar-link">Ver</a></li>
					</ul></li>
				<li class="sidebar-item"><a href="#"
					class="sidebar-link collapsed has-dropdown"
					data-bs-toggle="collapse" data-bs-target="#wallet"
					aria-expanded="false" aria-controls="wallet"> <svg
							xmlns="http://www.w3.org/2000/svg"
							class="icon icon-tabler icon-tabler-wallet" width="24"
							height="24" viewBox="0 0 24 24" stroke-width="1.5"
							stroke="#ffffff" fill="none" stroke-linecap="round"
							stroke-linejoin="round">
                <path stroke="none" d="M0 0h24v24H0z" fill="none" />
                <path
								d="M17 8v-3a1 1 0 0 0 -1 -1h-10a2 2 0 0 0 0 4h12a1 1 0 0 1 1 1v3m0 4v3a1 1 0 0 1 -1 1h-12a2 2 0 0 1 -2 -2v-12" />
                <path d="M20 12v4h-4a2 2 0 0 1 0 -4h4" />
              </svg> <span>Wallet</span>
				</a>
					<ul id="wallet" class="sidebar-dropdown list-unstyled collapse"
						data-bs-parent="#sidebar">
						<li class="sidebar-item"><a href="${pageContext.request.contextPath}/Depositar"
							class="sidebar-link">Depositar</a></li>
						<li class="sidebar-item"><a href="${pageContext.request.contextPath}/Enviar"
							class="sidebar-link">Enviar</a></li>
					</ul></li>
				<li class="sidebar-item"><a href="${pageContext.request.contextPath}/ListarTransacciones"
					class="sidebar-link"> <svg xmlns="http://www.w3.org/2000/svg"
							class="icon icon-tabler icon-tabler-arrows-down-up" width="24"
							height="24" viewBox="0 0 24 24" stroke-width="1.5"
							stroke="#ffffff" fill="none" stroke-linecap="round"
							stroke-linejoin="round">
                <path stroke="none" d="M0 0h24v24H0z" fill="none" />
                <path d="M17 3l0 18" />
                <path d="M10 18l-3 3l-3 -3" />
                <path d="M7 21l0 -18" />
                <path d="M20 6l-3 -3l-3 3" />
              </svg> <span>Transferencias</span>
				</a></li>
			</ul>
			<div class="sidebar-footer">
				<a id="logout" href="${pageContext.request.contextPath}/CerrarSession" class="sidebar-link"> <svg
						xmlns="http://www.w3.org/2000/svg"
						class="icon icon-tabler icon-tabler-logout" width="24" height="24"
						viewBox="0 0 24 24" stroke-width="1.5" stroke="#ffffff"
						fill="none" stroke-linecap="round" stroke-linejoin="round">
              <path stroke="none" d="M0 0h24v24H0z" fill="none" />
              <path
							d="M14 8v-2a2 2 0 0 0 -2 -2h-7a2 2 0 0 0 -2 2v12a2 2 0 0 0 2 2h7a2 2 0 0 0 2 -2v-2" />
              <path d="M9 12h12l-3 -3" />
              <path d="M18 15l3 -3" />
            </svg> <span>Logout</span>
				</a>
			</div>
		</aside>
		

		