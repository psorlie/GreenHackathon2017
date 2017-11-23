<div class="offset-lg-1 col-lg-10 ">
			  
					<div class="card mb-3">
						<div class="card-header">
							<i class="fa fa-search"></i> <strong>Parametres de recherche</strong></div>
							<div class="card-body">
								<div class="row">
									<div class="col-12">
									<form class="form-horizontal" action="ResultatsRecherche"
										method="get">
										<div class="row">
												<div class="form-group col-lg-4 offset-lg-1 ">
													<div class="form-group">
														<label class="control-label col-xs-1 col-lg-12" for=""><strong>Nom </strong></label>
													</div>
													<div class="form-group">
														<input type="text" id="nom" name="nom" class="control-label form-control col-xs-2 col-lg-12" />
													</div>
												</div>

												<div class="form-group col-lg-4 offset-lg-2">
													<div class="form-group">
														<label class="control-label col-xs-1 col-lg-12" for=""><strong>Ville </strong></label>
													</div>
													<div class="form-group">
														<input type="text" id="ville" name="ville" class="control-label form-control col-xs-2 col-lg-12" />
													</div>
												</div>
										</div>
										<div class="form-group">
											<button type="button" class="btn btn-info offset-lg-1" data-toggle="collapse" data-target="#avance">Recherche Avancee</button>
										</div>
										<div id="avance" class="form-horizontal collapse">
											
											<div class="form-group offset-lg-1" >
												<label class="control-label col-lg-5 " for=""><strong>Jour</strong></label>
											</div>
											
											<div class="form-group">
												<div class="form-inline">
													<div class="form-group col-lg-1 offset-lg-1">
														<div class="form-check">
															<label class="form-check-label"> <input
																class="form-check-input" type="checkbox" name="lundi" id="lundi">Lundi
															</label>
														</div>
													</div>
													<div class="form-group col-lg-1 offset-lg-1">
														<div class="form-check">
															<label class="form-check-label"> <input
																class="form-check-input" type="checkbox" name="mardi" id="mardi">Mardi
															</label>
														</div>
													</div>
													<div class="form-group col-lg-1 offset-lg-1">
														<div class="form-check">
															<label class="form-check-label"> <input
																class="form-check-input" type="checkbox" name="mercredi" id="mercredi">Mercredi
															</label>
														</div>
													</div>
													<div class="form-group col-lg-1 offset-lg-1">
														<div class="form-check">
															<label class="form-check-label"> <input
																class="form-check-input" type="checkbox" name="jeudi" id="jeudi">Jeudi
															</label>
														</div>
													</div>
													<div class="form-group col-lg-1 offset-lg-1">
														<div class="form-check">
															<label class="form-check-label"> <input
																class="form-check-input" type="checkbox" name="vendredi" id="vendredi">Vendredi
															</label>
														</div>
													</div>
												</div>
											</div>
											
											<div class="form-group">
												<div class="form-inline">
													<div class="form-group  col-lg-5 offset-lg-1">
														<label class="control-label" for=""><strong>Disponibilites de</strong></label>
														<select name="horaire_debut" id="horaire_debut"
															class="control-label col-lg-4 offset-lg-2">
															<option value="6">6:00</option>
															<option value="7">7:00</option>
															<option value="8">8:00</option>
															<option value="9">9:00</option>
															<option value="10">10:00</option>
															<option value="11">11:00</option>
															<option value="12">12:00</option>
															<option value="13">13:00</option>
															<option value="14">14:00</option>
															<option value="15">15:00</option>
															<option value="16">16:00</option>
															<option value="17">17:00</option>
															<option value="18">18:00</option>
															<option value="19">19:00</option>
														</select>
													</div>
													<div class="form-group col-lg-5 ">
														<label class="control-label" for=""><strong> a </strong></label>
														<select name="horaire_fin" id="horaires_fin"
															class="control-label col-lg-4 offset-lg-2">
															<option value="6">6:00</option>
															<option value="7">7:00</option>
															<option value="8">8:00</option>
															<option value="9">9:00</option>
															<option value="10">10:00</option>
															<option value="11">11:00</option>
															<option value="12">12:00</option>
															<option value="13">13:00</option>
															<option value="14">14:00</option>
															<option value="15">15:00</option>
															<option value="16">16:00</option>
															<option value="17">17:00</option>
															<option value="18">18:00</option>
															<option value="19">19:00</option>
														</select>
													</div>
												</div>
											</div>
											<div class="form-group offset-lg-1">
												<label class="control-label col-lg-3" for=""><strong>Specialite </strong></label> 
												<select	name="specialite" id="specialite" class="control-label col-lg-3 offset-lg-1">
													<option value="1">a</option>
													<option value="2">b</option>
													<option value="3">c</option>
													<option value="4">d</option>
												</select>
											</div>
											</div>
											<div class="form-group">
											<button type="submit" class="btn btn-success offset-lg-1">Rechercher !</button>
											</div>
										</div>
										</div>
										
									</form>
								</div>
								</div>
							</div>
					</div>
				